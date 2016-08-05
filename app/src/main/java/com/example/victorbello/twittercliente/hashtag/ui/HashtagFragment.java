package com.example.victorbello.twittercliente.hashtag.ui;

/**
 * Created by victorbello on 22/07/16.
 */

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.Snackbar;

import com.example.victorbello.twittercliente.R;
import com.example.victorbello.twittercliente.TwitterClientApp;
import com.example.victorbello.twittercliente.entities.Hashtag;
import com.example.victorbello.twittercliente.hashtag.HashtagPresenter;
import com.example.victorbello.twittercliente.hashtag.di.HashtagComponent;
import com.example.victorbello.twittercliente.hashtag.ui.adapters.HashtagAdapter;
import com.example.victorbello.twittercliente.hashtag.ui.adapters.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

public class HashtagFragment extends Fragment implements HashtagView, OnItemClickListener {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private FrameLayout container;

    @Inject
    public HashtagPresenter presenter;
    @Inject
    public HashtagAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup content, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.fragment_content,content,false);

        progressBar=(ProgressBar) view.findViewById(R.id.progressBar);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);
        container=(FrameLayout) view.findViewById(R.id.container);

        setupInjection();
        presenter.getHashtagTweets();
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setupInjection() {
        TwitterClientApp app=(TwitterClientApp)getActivity().getApplication();
        HashtagComponent hashtagComponent=app.getHashtagComponent(this,this);
        hashtagComponent.inject(this);
    }


    @Override
    public void onResume(){
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause(){
        presenter.onResume();
        super.onPause();
    }

    @Override
    public void onDestroy(){
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showTweets() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTweets() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showProgrees() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String error) {
        Snackbar.make(container,error,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setContent(List<Hashtag> items) {
        adapter.setItems(items);
    }

    @Override
    public void onItemClick(Hashtag hashtag) {

    }
}
