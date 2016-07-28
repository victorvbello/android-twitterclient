package com.example.victorbello.twittercliente.images;

/**
 * Created by victorbello on 22/07/16.
 */
public class ImagesInteractorImpl implements ImagesInteractor {

    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository){
        this.repository=repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
