package com.covani.xyralitytest;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.covani.xyralitytest.model.AllAvailableWorlds;
import com.covani.xyralitytest.model.GamesResponse;
import com.covani.xyralitytest.ui.MainFragment;
import com.google.gson.Gson;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by Covani on 14.10.2015.
 */
public class DataPresenter {

    public static final String BASE_URL = "http://backend1.lordsandknights.com/XYRALITY/WebObjects/BKLoginServer.woa";

    private GamesListView mGamesListView;

    private static GamesResponse mCachedGamesResponse;

    public DataPresenter(GamesListView gamesListView) {
        mGamesListView = gamesListView;
    }

    public void loadAvailavleGamesList() {
        if (mCachedGamesResponse == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BASE_URL)
                    .setConverter(new GsonConverter(new Gson())).build();
            NetworkService networkService = restAdapter.create(NetworkService.class);
            mGamesListView.showLoading();
            String login = mGamesListView.getArguments().getString(MainFragment.LOGIN);
            String password = mGamesListView.getArguments().getString(MainFragment.PASSWORD);
            String deviceType = String.format("%s %s", Build.MODEL, Build.VERSION.RELEASE);
            WifiManager manager = (WifiManager) ((Fragment) mGamesListView).getActivity().getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = manager.getConnectionInfo();
            String deviceId = info.getMacAddress();
            if (deviceId == null) {
                deviceId = String.valueOf(System.currentTimeMillis());
            }
            networkService.getAvailableGames(login, password, deviceType, deviceId, mResponseCallback);
        } else {
            mResponseCallback.success(mCachedGamesResponse, null);
        }
    }

    public static void setCachedGamesResponse(GamesResponse mCachedGamesResponse) {
        DataPresenter.mCachedGamesResponse = mCachedGamesResponse;
    }

    private Callback<GamesResponse> mResponseCallback = new Callback<GamesResponse>() {

        @Override
        public void success(GamesResponse gamesResponse, Response response) {
            mCachedGamesResponse = gamesResponse;
            mGamesListView.setData(mCachedGamesResponse.getAllAvailableWorlds());
            mGamesListView.hideLoading();
        }

        @Override
        public void failure(RetrofitError error) {
            mGamesListView.showError(error);
            mGamesListView.hideLoading();
        }
    };

    public interface GamesListView {

        void showLoading();

        void hideLoading();

        void setData(AllAvailableWorlds[] allAvailableWorlds);

        void showError(RetrofitError error);

        Bundle getArguments();

    }

    private interface NetworkService {
        @Headers("Accept: application/json")
        @FormUrlEncoded
        @POST("/wa/worlds")
        void getAvailableGames(@Field("login") String login,
                               @Field("password") String password,
                               @Field("deviceType") String deviceType,
                               @Field("deviceId") String deviceId, Callback<GamesResponse> callback);

    }
}
