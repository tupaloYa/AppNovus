package com.newtest.novusapp.fragments;

/**
 * Created by ������� on 06.08.2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtest.novusapp.R;

public class ScreenSeven extends Fragment{
    public ScreenSeven() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.screen_seven, container,
                false);

        return rootView;
    }
}
