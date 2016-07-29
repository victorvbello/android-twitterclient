package com.example.victorbello.twittercliente.hashtag.event;

/**
 * Created by victorbello on 29/07/16.
 */

import java.util.List;

import com.example.victorbello.twittercliente.entities.Hashtag;

public class HashtagEvent {

    private String error;
    private List<Hashtag> hashtags;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
