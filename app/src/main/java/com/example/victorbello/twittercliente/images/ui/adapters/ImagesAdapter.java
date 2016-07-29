package com.example.victorbello.twittercliente.images.ui.adapters;

/**
 * Created by victorbello on 28/07/16.
 */

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import com.example.victorbello.twittercliente.R;
import com.example.victorbello.twittercliente.entities.Image;
import com.example.victorbello.twittercliente.lib.base.ImageLoader;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private List<Image> dataset;
    private ImageLoader imagenLoader;
    private OnItemClickListener clickListener;

    public ImagesAdapter (List<Image> dataset, ImageLoader imagenLoader, OnItemClickListener clickListener){
        this.dataset=dataset;
        this.imagenLoader=imagenLoader;
        this.clickListener=clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.content_images,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image imageTweet=dataset.get(position);
        holder.setOnClickListener(imageTweet,clickListener);
        holder.txtTweet.setText(imageTweet.getTweetText());
        imagenLoader.load(holder.imgMedia,imageTweet.getImageURL());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setItems(List<Image> newItems){
        dataset.addAll(newItems);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private ImageView imgMedia;
        private TextView txtTweet;

        public ViewHolder(View itemView) {
            super(itemView);
            imgMedia=(ImageView)itemView.findViewById(R.id.imgMedia);
            txtTweet=(TextView)itemView.findViewById(R.id.txtTweet);
            this.view=itemView;
        }

        public void setOnClickListener(final Image image, final OnItemClickListener listener){
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(image);
                }
            });
        }
    }
}
