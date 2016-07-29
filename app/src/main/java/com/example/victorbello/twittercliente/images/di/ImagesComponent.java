package com.example.victorbello.twittercliente.images.di;


/**
 * Created by victorbello on 29/07/16.
 */

import com.example.victorbello.twittercliente.images.ImagesPresenter;
import com.example.victorbello.twittercliente.images.ui.ImagesFragment;
import com.example.victorbello.twittercliente.lib.di.LibsModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton @Component(modules={LibsModule.class,ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();
}
