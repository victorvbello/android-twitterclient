package com.example.victorbello.twittercliente.hashtag;

/**
 * Created by victorbello on 22/07/16.
 */

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.TextView;

public class HashtagFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup content, Bundle savedInstanceState){
        TextView textView=new TextView(getActivity());
        textView.setText("Fragment hashtag");
        return textView;
    }
}
