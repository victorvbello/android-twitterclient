package com.example.victorbello.twittercliente.hashtag.ui.adapters;

/**
 * Created by victorbello on 29/07/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.example.victorbello.twittercliente.entities.Hashtag;
import com.example.victorbello.twittercliente.hashtag.ui.adapters.OnItemClickListener;

public class HashtagAdapter extends RecyclerView.Adapter<HashtagAdapter.ViewHolder> {

    private List<Hashtag> dataset;
    private OnItemClickListener clickListener;

    public HashtagAdapter(List<Hashtag> dataset, OnItemClickListener clickListener) {
        this.dataset = dataset;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
