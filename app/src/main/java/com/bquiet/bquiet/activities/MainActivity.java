package com.bquiet.bquiet.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.fragments.FragmentTab;
import com.bquiet.bquiet.manager.RecorderManager;
import com.github.anastr.speedviewlib.Speedometer;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubquiet, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost) findViewById(R.id.activity_main_tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.activity_main__tabcontent);

        mTabHost.addTab(
                mTabHost.newTabSpec("Noisemetre").setIndicator("Noisemetre", null),
                FragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("My Class").setIndicator("My Class", null),
                FragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Noise Level").setIndicator("Noise Level", null),
                FragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Graphics").setIndicator("Graphics", null),
                FragmentTab.class, null);

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