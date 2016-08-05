package com.example.victorbello.twittercliente;

/**
 * Created by victorbello on 20/07/16.
 */

import android.app.Application;
import android.support.v4.app.Fragment;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import com.example.victorbello.twittercliente.hashtag.di.DaggerHashtagComponent;
import com.example.victorbello.twittercliente.hashtag.di.HashtagModule;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import com.example.victorbello.twittercliente.images.di.DaggerImagesComponent;
import com.example.victorbello.twittercliente.images.di.ImagesModule;
import com.example.victorbello.twittercliente.images.di.ImagesComponent;
import com.example.victorbello.twittercliente.images.ui.ImagesView;
import com.example.victorbello.twittercliente.hashtag.di.HashtagComponent;
import com.example.victorbello.twittercliente.hashtag.ui.HashtagView;
import com.example.victorbello.twittercliente.lib.di.LibsModule;

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

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView imagesView, com.example.victorbello.twittercliente.images.ui.adapters.OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(imagesView,clickListener))
                .build();
    }

    public HashtagComponent getHashtagComponent(HashtagView hashtagView, com.example.victorbello.twittercliente.hashtag.ui.adapters.OnItemClickListener clickListener){
        return DaggerHashtagComponent
                .builder()
                .libsModule(new LibsModule(null))
                .hashtagModule(new HashtagModule(hashtagView,clickListener))
                .build();
    }
}
