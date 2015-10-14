package com.covani.xyralitytest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.covani.xyralitytest.model.AllAvailableWorlds;

/**
 * Created by Covani on 14.10.2015.
 */
public class GamesListAdapter extends RecyclerView.Adapter<GamesListAdapter.GameViewHolder> {

    private AllAvailableWorlds[] mAllAvailableWorlds;
    private Context mContext;

    public GamesListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GameViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.view_game, null));
    }

    public void setAllAvailableWorlds(AllAvailableWorlds[] allAvailableWorlds) {
        mAllAvailableWorlds = allAvailableWorlds;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        if (mAllAvailableWorlds != null) {
            holder.setName(mAllAvailableWorlds[position].getName());
        }
    }

    @Override
    public int getItemCount() {
        return mAllAvailableWorlds == null ? 0 : mAllAvailableWorlds.length;
    }

    class GameViewHolder extends RecyclerView.ViewHolder {
        TextView mGameNameTextView;

        public GameViewHolder(View itemView) {
            super(itemView);
            mGameNameTextView = (TextView) itemView.findViewById(R.id.text_view_game_name);
        }

        public void setName(String name) {
            mGameNameTextView.setText(name);
        }
    }
}
