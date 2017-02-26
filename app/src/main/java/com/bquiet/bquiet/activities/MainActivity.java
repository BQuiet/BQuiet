package com.bquiet.bquiet.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.manager.RecorderManager;
import com.github.anastr.speedviewlib.Speedometer;

public class MainActivity extends AppCompatActivity {
    public static final float HIGH_NOISE = 50;
    public static final float MEDIUM_NOISE = 40;


    private Speedometer speedometer;
    private Speedometer speedometer2;

    private ImageButton playButton;
    private ImageButton pauseButton;
    private LinearLayout layout;

    private boolean speedometreWithTremble = false;

    RecorderManager recorderManager;
    RecorderManager.Ear ear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedometer = (Speedometer) findViewById(R.id.speedView);
        //speedometer2 = (Speedometer) findViewById(R.id.awesomeSpeedometer);
        playButton = (ImageButton) findViewById(R.id.activity_main_play_button);
        pauseButton = (ImageButton) findViewById(R.id.activity_main_pause_button);
        layout = (LinearLayout) findViewById(R.id.activity_main_layout);

        speedometer.setWithTremble(speedometreWithTremble);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recorderManager = new RecorderManager();
                ear = recorderManager.new Ear();
                ear.setOnEarListener(new RecorderManager.EarListener() {
                    @Override
                    public void newValueFromEar(double spl) {
                        speedometer.speedTo((float) spl);
                        changeBackgroundImage((float) spl);
                        //speedometer2.speedTo((float) spl);
                    }
                });
                recorderManager.setListening(true);
                //ear.cancel(recorderManager.isListening());
                ear.execute();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recorderManager.setListening(false);
                speedometer.speedTo(0.0f);
                recorderManager.stopMediaRecorder();
                ear.cancel(recorderManager.isListening());
            }
        });
    }

    private void changeBackgroundImage(float noiseLevel) {
        if(noiseLevel < MEDIUM_NOISE) {
            layout.setBackgroundResource(R.drawable.teacher_low_noise);
        } else if(noiseLevel > MEDIUM_NOISE && noiseLevel < HIGH_NOISE) {
            layout.setBackgroundResource(R.drawable.teacher_medium_noise);
        } else if(noiseLevel > HIGH_NOISE) {
            layout.setBackgroundResource(R.drawable.teacher_high_noise);
        }
    }
}