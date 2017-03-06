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
public class GraphicsFragment extends Fragment {


    public GraphicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_graphics, container, false);
    }
    public static Fragment newInstance() {
        GraphicsFragment myFragment = new GraphicsFragment();
        return myFragment;

    }
}
