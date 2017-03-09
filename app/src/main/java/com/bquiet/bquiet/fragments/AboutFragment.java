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
public class AboutFragment extends Fragment {




    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);





        return view;
    }

    public static Fragment newInstance() {
        AboutFragment myFragment = new AboutFragment();
        return myFragment;

    }

}
