package com.newtest.novusapp.fragments;

/**
 * Created by ярослав on 06.08.2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtest.novusapp.R;

public class ScreenNine extends Fragment{
    public ScreenNine() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.screen_nine, container,
                false);

        return rootView;
    }
}
