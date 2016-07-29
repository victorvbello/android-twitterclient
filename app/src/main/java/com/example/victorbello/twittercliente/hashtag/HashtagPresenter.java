package com.example.victorbello.twittercliente.hashtag;

/**
 * Created by victorbello on 29/07/16.
 */

import com.example.victorbello.twittercliente.hashtag.event.HashtagEvent;

public interface HashtagPresenter {

    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagEvent event);
}
