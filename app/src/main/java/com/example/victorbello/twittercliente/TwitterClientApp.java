package com.example.victorbello.twittercliente;

/**
 * Created by victorbello on 20/07/16.
 */

import android.app.Application;
import android.support.v4.app.Fragment;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import com.example.victorbello.twittercliente.images.di.DaggerImagesComponent;
import com.example.victorbello.twittercliente.images.di.ImagesModule;
import com.example.victorbello.twittercliente.images.ui.adapters.OnItemClickListener;
import com.example.victorbello.twittercliente.lib.di.LibsModule;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import com.example.victorbello.twittercliente.images.di.ImagesComponent;
import com.example.victorbello.twittercliente.images.ui.ImagesView;

public class TwitterClientApp extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        intFabric();
    }

    public void intFabric(){
        TwitterAuthConfig authConfig=new TwitterAuthConfig(BuildConfig.TWITTER_KEY,BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new Crashlytics(),new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView imagesView, OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(imagesView,clickListener))
                .build();
    }
}
