package com.example.victorbello.twittercliente.images.di;


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
import com.example.victorbello.twittercliente.entities.Image;
import com.example.victorbello.twittercliente.images.ImagesInteractor;
import com.example.victorbello.twittercliente.images.ImagesInteractorImpl;
import com.example.victorbello.twittercliente.images.ImagesPresenter;
import com.example.victorbello.twittercliente.images.ImagesPresenterImpl;
import com.example.victorbello.twittercliente.images.ImagesRepository;
import com.example.victorbello.twittercliente.images.ImagesRepositoryImpl;
import com.example.victorbello.twittercliente.images.ui.ImagesView;
import com.example.victorbello.twittercliente.images.ui.adapters.ImagesAdapter;
import com.example.victorbello.twittercliente.images.ui.adapters.OnItemClickListener;
import com.example.victorbello.twittercliente.lib.base.EventBus;
import com.example.victorbello.twittercliente.lib.base.ImageLoader;

@Module
public class ImagesModule {

    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    public ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imagenLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dataset,imagenLoader,clickListener);
    }

    @Provides
    @Singleton
    public OnItemClickListener providesOnItemClickListener(){
        return clickListener;
    }

    @Provides
    @Singleton
    public List<Image> providesItemsList(){
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    public ImagesPresenter providesImagesPresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor){
        return new ImagesPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    public ImagesView providesImagesView(){
        return view;
    }

    @Provides
    @Singleton
    public ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    public ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient cliente){
        return new ImagesRepositoryImpl(eventBus, cliente);
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
