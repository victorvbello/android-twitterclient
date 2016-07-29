package com.example.victorbello.twittercliente.images;


/**
 * Created by victorbello on 22/07/16.
 */


import android.util.Log;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.Callback;

import com.example.victorbello.twittercliente.api.CustomTwitterApiClient;
import com.example.victorbello.twittercliente.lib.base.EventBus;
import com.example.victorbello.twittercliente.entities.Image;
import com.example.victorbello.twittercliente.images.events.ImagesEvent;

public class ImagesRepositoryImpl implements ImagesRepository {

    private EventBus eventBus;
    private CustomTwitterApiClient cliente;
    private final static int TWEET_COUNT=100;

    public ImagesRepositoryImpl(EventBus eventBus, CustomTwitterApiClient cliente){
        this.eventBus=eventBus;
        this.cliente=cliente;
    }

    @Override
    public void getImages() {
        Log.i("TW-ImagesRepositoryImpl","getImages");
        Callback<List<Tweet>> callback= new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                Log.i("TW-ImagesRepositoryImpl","success "+result.data.size());
                List<Image> items=new ArrayList<Image>();
                for(Tweet tweet: result.data){
                    if(containsImages(tweet)){
                        Image tweetModel=new Image();

                        tweetModel.setId(tweet.idStr);
                        tweetModel.setFavoriteCount(tweet.favoriteCount);

                        String tweetText=tweet.text;
                        int index =tweetText.indexOf("http");
                        if(index>0){
                            tweetText=tweetText.substring(0,index);
                        }
                        tweetModel.setTweetText(tweetText);

                        MediaEntity currentPhoto=tweet.entities.media.get(0);
                        String imageUrl=currentPhoto.mediaUrl;
                        tweetModel.setImageURL(imageUrl);

                        items.add(tweetModel);
                    }
                }
                Collections.sort(items, new Comparator<Image>() {
                    @Override
                    public int compare(Image image, Image t1) {
                        return t1.getFavoriteCount()-image.getFavoriteCount();
                    }
                });
                post(items);
                Log.i("TW-ImagesRepositoryImpl","getImages "+items.size());
            }

            @Override
            public void failure(TwitterException exception) {
                post(exception.getLocalizedMessage());
            }
        };
        cliente.getTimelineService().homeTimeline(TWEET_COUNT,true,true,true,true,callback);
    }

    private boolean containsImages(Tweet tweet){
        return  tweet.entities!=null &&
                tweet.entities.media!=null &&
                !tweet.entities.media.isEmpty();
    }

    private void post(List<Image> items){
        post(items,null);
    }

    private void post(String error){
        post(null,error);
    }

    private void post(List<Image> items, String error){
        ImagesEvent event=new ImagesEvent();
        event.setError(error);
        event.setImages(items);
        eventBus.post(event);

    }
}
