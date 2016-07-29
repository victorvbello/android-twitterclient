package com.example.victorbello.twittercliente.hashtag.di;


/**
 * Created by victorbello on 29/07/16.
 */


import javax.inject.Singleton;

import dagger.Component;

import com.example.victorbello.twittercliente.hashtag.HashtagPresenter;
import com.example.victorbello.twittercliente.hashtag.ui.HashtagFragment;
import com.example.victorbello.twittercliente.lib.di.LibsModule;

@Singleton @Component(modules = {LibsModule.class,HashtagModule.class})
public interface HashtagComponent {
    void inject(HashtagFragment fragment);
    HashtagPresenter getPresenter();
}
