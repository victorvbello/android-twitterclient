package com.example.victorbello.twittercliente.hashtag.ui.adapters;

/**
 * Created by victorbello on 05/08/16.
 */

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

import com.example.victorbello.twittercliente.R;

public class HashtagListAdapter extends RecyclerView.Adapter<HashtagListAdapter.ViewHolder> {

    private List<String> items;

    public HashtagListAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hashtag_text,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtHastag.setText(items.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtHastag;

        public ViewHolder(View itemView) {
            super(itemView);
            txtHastag=(TextView) itemView.findViewById(R.id.txtHastag);
        }
    }
}
