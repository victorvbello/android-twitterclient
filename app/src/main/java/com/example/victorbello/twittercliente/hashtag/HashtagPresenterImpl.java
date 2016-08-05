package com.example.victorbello.twittercliente.hashtag;


/**
 * Created by victorbello on 01/08/16.
 */

import com.example.victorbello.twittercliente.hashtag.event.HashtagEvent;
import com.example.victorbello.twittercliente.hashtag.ui.HashtagView;
import com.example.victorbello.twittercliente.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

public class HashtagPresenterImpl implements HashtagPresenter {

    private HashtagView view;
    private EventBus eventBus;
    private HashtagInteractor interactor;

    public HashtagPresenterImpl(HashtagView view, EventBus eventBus, HashtagInteractor interactor){
        this.view=view;
        this.eventBus=eventBus;
        this.interactor=interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view=null;
    }

    @Override
    public void getHashtagTweets() {
        if(view!=null){
            view.hideTweets();
            view.showProgrees();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagEvent event) {
        String errorMsg=event.getError();
        if(view!=null){
            view.showTweets();
            view.hideProgress();
            if(errorMsg!=null){
                view.onError(errorMsg);
            }else{
                view.setContent(event.getHashtags());
            }
        }
    }
}
