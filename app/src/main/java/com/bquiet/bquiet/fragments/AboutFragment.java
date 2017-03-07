package com.bquiet.bquiet.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.activities.DevelopersActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    @BindView(R.id.fragment_about_RN__Telephone)TextView telephone_robonautas;
    @BindView(R.id.fragment_about_RN__Email)TextView email_robonautas;
    @BindView(R.id.fragment_about_RN__web)TextView web_robonautas;
    @BindView(R.id.fragment_about_BQ__gitHub)TextView adress_github_BQ;
    @BindView(R.id.fragment_aboout___button_bquiet)ImageView button_developers;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);

        telephone_robonautas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        email_robonautas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        web_robonautas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent developer = new Intent(getContext(), DevelopersActivity.class);
                startActivity(developer);
            }
        });

        adress_github_BQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;



    }

}
