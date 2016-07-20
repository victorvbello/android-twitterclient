package com.example.victorbello.twittercliente;

/**
 * Created by victorbello on 20/07/16.
 */

import android.app.Application;
import io.fabric.sdk.android.Fabric;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;


public class TwitterClientApp extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        intFabric();
    }

    public void intFabric(){
        TwitterAuthConfig authConfig=new TwitterAuthConfig(BuildConfig.TWITTER_KEY,BuildConfig.TWITTER_SECRET);
        Fabric.with(this,new Twitter(authConfig));
    }
}
