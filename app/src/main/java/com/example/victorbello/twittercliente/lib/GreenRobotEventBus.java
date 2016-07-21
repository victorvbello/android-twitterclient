package com.example.victorbello.twittercliente.lib;


/**
 * Created by victorbello on 20/07/16.
 */

import com.example.victorbello.twittercliente.lib.base.EventBus;

public class GreenRobotEventBus implements EventBus {

    private org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus(org.greenrobot.eventbus.EventBus eventBus){
        this.eventBus=eventBus;
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
