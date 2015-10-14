package com.covani.xyralitytest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Covani on 14.10.2015.
 */
public class GamesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String login = getArguments().getString(MainFragment.LOGIN);
        String pass = getArguments().getString(MainFragment.PASSWORD);
        Log.e("TAG", login + " " + pass);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
