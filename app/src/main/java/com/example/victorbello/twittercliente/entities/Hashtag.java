package com.example.victorbello.twittercliente.entities;

/**
 * Created by victorbello on 29/07/16.
 */

import java.util.List;

public class Hashtag {

    private String id;
    private String tweetText;
    private int favoriteCount;
    private List<String> hastags;
    private final static String BASE_TWEET_URL="https://twitter.com/null/status";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public List<String> getHastags() {
        return hastags;
    }

    public void setHastags(List<String> hastags) {
        this.hastags = hastags;
    }

    public String getBaseTweetUrl() {
        return BASE_TWEET_URL + this.id;
    }
}
