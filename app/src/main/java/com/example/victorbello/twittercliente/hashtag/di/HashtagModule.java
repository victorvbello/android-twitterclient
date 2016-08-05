package com.example.victorbello.twittercliente.hashtag.di;


/**
 * Created by victorbello on 29/07/16.
 */


import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import com.example.victorbello.twittercliente.api.CustomTwitterApiClient;
import com.example.victorbello.twittercliente.entities.Hashtag;
import com.example.victorbello.twittercliente.hashtag.HashtagInteractor;
import com.example.victorbello.twittercliente.hashtag.HashtagInteractorImpl;
import com.example.victorbello.twittercliente.hashtag.HashtagRepository;
import com.example.victorbello.twittercliente.hashtag.HashtagRepositoryImpl;
import com.example.victorbello.twittercliente.hashtag.ui.HashtagView;
import com.example.victorbello.twittercliente.hashtag.ui.adapters.HashtagAdapter;
import com.example.victorbello.twittercliente.hashtag.ui.adapters.OnItemClickListener;
import com.example.victorbello.twittercliente.hashtag.HashtagPresenter;
import com.example.victorbello.twittercliente.hashtag.HashtagPresenterImpl;
import com.example.victorbello.twittercliente.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

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

    @Provides
    @Singleton
    public HashtagPresenter providesHashtagPresenter(HashtagView view ,EventBus eventBus, HashtagInteractor interactor){
        return new HashtagPresenterImpl(view,eventBus,interactor);
    }

    @Provides
    @Subscribe
    public HashtagView providesHashtagView(){
        return view;
    }

    @Provides
    @Subscribe
    public HashtagInteractor providesHashtagInteractor(HashtagRepository repository){
        return new HashtagInteractorImpl(repository);
    }

    @Provides
    @Subscribe
    public HashtagRepository providesHashtagRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new HashtagRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    public CustomTwitterApiClient providesCustomTwitterApiClient(Session session){
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    public Session providesTwitter(){
        return Twitter.getSessionManager().getActiveSession();
    }
}
