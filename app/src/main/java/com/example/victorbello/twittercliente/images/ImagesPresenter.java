package com.example.victorbello.twittercliente.images;

/**
 * Created by victorbello on 22/07/16.
 */

import com.example.victorbello.twittercliente.images.events.ImagesEvent;

public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
