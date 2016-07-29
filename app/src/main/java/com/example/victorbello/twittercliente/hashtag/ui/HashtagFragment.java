package com.example.victorbello.twittercliente.hashtag.ui;

/**
 * Created by victorbello on 22/07/16.
 */

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.victorbello.twittercliente.entities.Hashtag;

import java.util.List;

public class HashtagFragment extends Fragment implements HashtagView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup content, Bundle savedInstanceState){
        TextView textView=new TextView(getActivity());
        textView.setText("Fragment hashtag");
        return textView;
    }

    @Override
    public void showTweets() {

    }

    @Override
    public void hideTweets() {

    }

    @Override
    public void showProgrees() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void setContent(List<Hashtag> items) {

    }
}
