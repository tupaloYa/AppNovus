package com.newtest.novusapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtest.novusapp.R;

/**
 * Created by ������� on 05.08.2015.
 */
public class ScreenTwo extends  Fragment{

    public ScreenTwo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.screen_two, container,
                false);

        return rootView;
    }
}
