package com.covani.xyralitytest.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.covani.xyralitytest.DataPresenter;
import com.covani.xyralitytest.GamesListAdapter;
import com.covani.xyralitytest.R;
import com.covani.xyralitytest.model.AllAvailableWorlds;

/**
 * Created by Covani on 14.10.2015.
 */
public class GamesFragment extends Fragment
        implements DataPresenter.GamesListView {

    private RecyclerView mGamesRecyclerView;
    private ProgressBar mGamesLoadingProgressBar;
    private DataPresenter mDataPresenter;
    private GamesListAdapter mGamesListAdapter;

    private boolean mIsLandscape;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_games, null);
        mGamesRecyclerView = (RecyclerView) view.findViewById(R.id.recyler_view_games);
        mGamesLoadingProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar_games_loading);
        mDataPresenter = new DataPresenter(this);
        mGamesListAdapter = new GamesListAdapter(getContext());
        mGamesRecyclerView.setAdapter(mGamesListAdapter);
        mIsLandscape = getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        mGamesRecyclerView.setLayoutManager(mIsLandscape
                ? new GridLayoutManager(getContext(), 3)
                : new LinearLayoutManager(getContext()));
        mDataPresenter.loadAvailavleGamesList();
        return view;
    }

    @Override
    public void showLoading() {
        mGamesLoadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mGamesLoadingProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setData(AllAvailableWorlds[] allAvailableWorlds) {
        mGamesListAdapter.setAllAvailableWorlds(allAvailableWorlds);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        getActivity().onBackPressed();
    }

}
