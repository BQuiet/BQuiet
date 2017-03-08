package com.bquiet.bquiet.fragments;


import android.content.Intent;
import android.net.Uri;
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

                Uri uri = Uri.parse("tel:" + "901082332");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);

            }
        });

        email_robonautas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:info@robonautas.com?subject" + "" + "&body=" + "");
                intent.setData(data);
                startActivity(intent);

            }
        });

        web_robonautas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.facebook.com/losrobonautas");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


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

                Uri uri = Uri.parse("https://github.com/BQuiet/BQuiet");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


        return view;
    }

    public static Fragment newInstance() {
        AboutFragment myFragment = new AboutFragment();
        return myFragment;

    }

}
