package com.bquiet.bquiet.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.manager.RecorderManager;

public class MainActivity extends AppCompatActivity {

    RecorderManager recorderManager = new RecorderManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        RecorderManager.Ear ear = recorderManager.new Ear();
        recorderManager.setListening(true);
        ear.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        recorderManager.stop();
    }
}
