package com.bquiet.bquiet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bquiet.bquiet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutBQuietFragment extends Fragment {


    public AboutBQuietFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_bquiet, container, false);
    }

}
