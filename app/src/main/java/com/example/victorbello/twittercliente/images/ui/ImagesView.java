package com.example.victorbello.twittercliente.images.ui;

/**
 * Created by victorbello on 22/07/16.
 */

import java.util.List;
import com.example.victorbello.twittercliente.entities.Image;

public interface ImagesView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String Error);
    void setContent(List<Image> items);

}
