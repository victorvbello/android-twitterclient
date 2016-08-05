package com.example.victorbello.twittercliente.hashtag;

/**
 * Created by victorbello on 29/07/16.
 */
public class HashtagInteractorImpl implements HashtagInteractor{

    private HashtagRepository repository;

    public HashtagInteractorImpl(HashtagRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getHashtags();
    }
}
