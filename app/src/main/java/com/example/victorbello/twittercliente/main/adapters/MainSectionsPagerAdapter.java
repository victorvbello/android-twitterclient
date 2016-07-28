package com.example.victorbello.twittercliente.main.adapters;

/**
 * Created by victorbello on 22/07/16.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainSectionsPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;
    private Fragment[] fragments;

    public MainSectionsPagerAdapter(FragmentManager fm, String[] titles,Fragment[] fragments){
        super(fm);
        this.titles=titles;
        this.fragments=fragments;
    }

    @Override
    public String getPageTitle(int position){
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
