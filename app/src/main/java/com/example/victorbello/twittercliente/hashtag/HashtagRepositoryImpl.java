package com.example.victorbello.twittercliente.hashtag;


/**
 * Created by victorbello on 29/07/16.
 */

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.Tweet;

import com.example.victorbello.twittercliente.api.CustomTwitterApiClient;
import com.example.victorbello.twittercliente.entities.Hashtag;
import com.example.victorbello.twittercliente.hashtag.event.HashtagEvent;
import com.example.victorbello.twittercliente.lib.base.EventBus;

public class HashtagRepositoryImpl implements HashtagRepository{

    private EventBus eventBus;
    private CustomTwitterApiClient client;
    private final static int TWEET_COUNT=100;


    public HashtagRepositoryImpl(EventBus eventBus, CustomTwitterApiClient client) {
        this.eventBus = eventBus;
        this.client = client;
    }

    @Override
    public void getHashtags() {
        Log.i("TW-ImagesRepositoryImpl","getImages");
        Callback<List<Tweet>> callback= new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                Log.i("TW-ImagesRepositoryImpl","success "+result.data.size());
                List<Hashtag> items=new ArrayList<Hashtag>();
                for(Tweet tweet: result.data){
                    if(containsHashtag(tweet)){
                        Hashtag tweetModel=new Hashtag();

                        tweetModel.setId(tweet.idStr);
                        tweetModel.setFavoriteCount(tweet.favoriteCount);
                        tweetModel.setTweetText(tweet.text);

                        List<String>hashtags=new ArrayList<String>();

                        for(HashtagEntity hashtag: tweet.entities.hashtags){
                            hashtags.add(hashtag.text);
                        }
                        tweetModel.setHastags(hashtags);

                        items.add(tweetModel);
                    }
                }
                Collections.sort(items, new Comparator<Hashtag>() {
                    @Override
                    public int compare(Hashtag t1, Hashtag t2) {
                        return t2.getFavoriteCount()-t1.getFavoriteCount();
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
        client.getTimelineService().homeTimeline(TWEET_COUNT,true,true,true,true,callback);
    }

    private boolean containsHashtag(Tweet tweet){
        return  tweet.entities!=null &&
                tweet.entities.hashtags!=null &&
                !tweet.entities.hashtags.isEmpty();
    }

    public void post(String error){
        post(null,error);
    }

    public void post(List<Hashtag> items){
        post(items,null);
    }

    public void post(List<Hashtag> items, String error){
        HashtagEvent event=new HashtagEvent();
        event.setHashtags(items);
        event.setError(error);
        eventBus.post(event);
    }
}
