package com.bquiet.bquiet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bquiet.bquiet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.fragment_aboout___button_bquiet)ImageView button_developers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        button_developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent developer = new Intent(AboutActivity.this, DevelopersActivity.class);
                startActivity(developer);
            }
        });
    }


}
