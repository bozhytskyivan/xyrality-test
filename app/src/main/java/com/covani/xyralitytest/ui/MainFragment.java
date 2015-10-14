package com.covani.xyralitytest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.covani.xyralitytest.R;

/**
 * Created by Covani on 14.10.2015.
 */
public class MainFragment extends Fragment {

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    private EditText mLoginTextView;
    private EditText mPasswordTextView;
    private Button mShowGamesButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, null);
        mLoginTextView = (EditText) view.findViewById(R.id.edit_text_login);
        mPasswordTextView = (EditText) view.findViewById(R.id.edit_text_password);
        mShowGamesButton = (Button) view.findViewById(R.id.button_show_games);
        mShowGamesButton.setOnClickListener(mOnClickListener);
        return view;
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bundle data = new Bundle();
            if (TextUtils.isEmpty(mLoginTextView.getText().toString())) {
                mLoginTextView.setError(getString(R.string.empty_textview_text));
            } else if (TextUtils.isEmpty(mPasswordTextView.getText().toString())) {
                mPasswordTextView.setError(getString(R.string.empty_textview_text));
            } else {
                data.putString(LOGIN, mLoginTextView.getText().toString());
                data.putString(PASSWORD, mPasswordTextView.getText().toString());
                Fragment gamesFragment = new GamesFragment();
                gamesFragment.setArguments(data);
                ((MainActivity) getActivity()).switchFragment(gamesFragment, true);
            }
        }
    };
}
