package com.example.victorbello.twittercliente.images.events;


/**
 * Created by victorbello on 22/07/16.
 */

import java.util.List;
import com.example.victorbello.twittercliente.entities.Image;

public class ImagesEvent {
    private String error;
    private List<Image> images;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
