package com.example.victorbello.twittercliente.images.ui;

/**
 * Created by victorbello on 22/07/16.
 */

import android.content.ClipData;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.Snackbar;

import android.net.Uri;
import java.util.List;

import com.example.victorbello.twittercliente.R;
import com.example.victorbello.twittercliente.entities.Image;
import com.example.victorbello.twittercliente.images.ImagesPresenter;
import com.example.victorbello.twittercliente.images.ui.adapters.ImagesAdapter;
import com.example.victorbello.twittercliente.images.ui.adapters.OnItemClickListener;


public class ImagesFragment extends Fragment implements ImagesView, OnItemClickListener{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FrameLayout container;

    private ImagesPresenter presenter;
    private ImagesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_content,container,false);

        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);
        progressBar=(ProgressBar) view.findViewById(R.id.progressBar);
        container=(FrameLayout) view.findViewById(R.id.container);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause(){
        presenter.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy(){
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showImages() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideImages() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String Error) {
        Snackbar.make(container,Error,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setContent(List<Image> items) {
        adapter.setItems(items);
    }

    @Override
    public void onItemClick(Image image) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(image.getTweetUrl()));
        startActivity(intent);
    }
}
