package com.bquiet.bquiet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bquiet.bquiet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.fragment_about_RN__Telephone)TextView telephone_robonautas;
    @BindView(R.id.fragment_about_RN__Email)TextView email_robonautas;
    @BindView(R.id.fragment_about_RN__web)TextView web_robonautas;
    @BindView(R.id.fragment_about_BQ__gitHub)TextView adress_github_BQ;
    @BindView(R.id.fragment_aboout___button_bquiet)ImageView button_developers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

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
                Intent developer = new Intent(AboutActivity.this, DevelopersActivity.class);
                startActivity(developer);
            }
        });

        adress_github_BQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
