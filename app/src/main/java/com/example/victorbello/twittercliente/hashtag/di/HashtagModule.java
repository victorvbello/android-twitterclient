package com.example.victorbello.twittercliente.hashtag.di;


/**
 * Created by victorbello on 29/07/16.
 */


import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

import com.example.victorbello.twittercliente.entities.Hashtag;
import com.example.victorbello.twittercliente.hashtag.ui.HashtagView;
import com.example.victorbello.twittercliente.hashtag.ui.adapters.HashtagAdapter;
import com.example.victorbello.twittercliente.hashtag.ui.adapters.OnItemClickListener;


@Module
public class HashtagModule {

    private HashtagView view;
    private OnItemClickListener clickListener;

    public HashtagModule(HashtagView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    public HashtagAdapter providesAdapter(List<Hashtag> dataset, OnItemClickListener clickListener){
        return new HashtagAdapter(dataset, clickListener);
    }

    @Provides
    @Singleton
    public OnItemClickListener providesOnItemClickListener(){
        return clickListener;
    }

    @Provides
    @Singleton
    public List<Hashtag> providesItemsList(){
        return new ArrayList<Hashtag>();
    }
}
