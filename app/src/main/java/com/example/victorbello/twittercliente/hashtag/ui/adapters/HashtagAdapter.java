package com.example.victorbello.twittercliente.hashtag.ui.adapters;

/**
 * Created by victorbello on 29/07/16.
 */

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.ArrayList;

import com.example.victorbello.twittercliente.R;
import com.example.victorbello.twittercliente.entities.Hashtag;
import com.example.victorbello.twittercliente.hashtag.ui.CustomGridLayoutManager;

public class HashtagAdapter extends RecyclerView.Adapter<HashtagAdapter.ViewHolder> {

    private List<Hashtag> dataset;
    private OnItemClickListener clickListener;

    public HashtagAdapter(List<Hashtag> dataset, OnItemClickListener clickListener) {
        this.dataset = dataset;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.content_hashtags,parent,false);
        return new ViewHolder(view,parent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hashtag tweet=dataset.get(position);
        holder.setOnClickListener(tweet,clickListener);
        holder.txtTweet.setText(tweet.getTweetText());
        holder.setItems(tweet.getHastags());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setItems(List<Hashtag> items){
        dataset.addAll(items);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTweet;
        private RecyclerView recyclerView;

        private View view;
        private HashtagListAdapter adapter;
        private ArrayList<String> items;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            txtTweet=(TextView) itemView.findViewById(R.id.txtTweet);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.recyclerView);
            this.view=itemView;

            items=new ArrayList<String>();
            adapter=new HashtagListAdapter(items);

            CustomGridLayoutManager layoutManager=new CustomGridLayoutManager(context,3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
        public void setItems(List<String> newItems){
            items.clear();
            items.addAll(newItems);
            Log.i("HashtagAdapter","Total Hashtag "+newItems.size());
            adapter.notifyDataSetChanged();
        }

        public void setOnClickListener(final Hashtag hashtag, final OnItemClickListener listener){
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    listener.onItemClick(hashtag);
                }
            });
        }
    }
}
