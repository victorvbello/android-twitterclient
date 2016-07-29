package com.example.victorbello.twittercliente.hashtag.ui;

/**
 * Created by victorbello on 29/07/16.
 */

import java.util.List;
import com.example.victorbello.twittercliente.entities.Hashtag;

public interface HashtagView {
    void showTweets();
    void hideTweets();
    void showProgrees();
    void hideProgress();

    void onError(String error);
    void setContent(List<Hashtag> items);
}
