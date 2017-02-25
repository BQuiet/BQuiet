package com.bquiet.bquiet.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.manager.RecorderManager;
import com.github.anastr.speedviewlib.Speedometer;

public class MainActivity extends AppCompatActivity {

    private static RecorderManager recorderManager = new RecorderManager();
    private Speedometer speedometer;
    private Speedometer speedometer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedometer = (Speedometer) findViewById(R.id.speedView);
        speedometer2 = (Speedometer) findViewById(R.id.awesomeSpeedometer);
    }

    @Override
    protected void onResume() {
        super.onResume();

        RecorderManager.Ear ear = recorderManager.new Ear();
        ear.setOnEarListener(new RecorderManager.EarListener() {
            @Override
            public void newValueFromEar(double spl) {
                speedometer.speedTo((float) spl);
                speedometer2.speedTo((float) spl);
            }
        });
        recorderManager.setListening(true);
        ear.execute();



    }

    @Override
    protected void onPause() {
        super.onPause();
        recorderManager.stop();
    }

}
