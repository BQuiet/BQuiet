package com.bquiet.bquiet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.manager.RecorderManager;
import com.github.anastr.speedviewlib.Speedometer;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab, container, false);

        speedometer = (Speedometer) v.findViewById(R.id.speedView);
        //speedometer2 = (Speedometer) v.findViewById(R.id.awesomeSpeedometer);
        playButton = (ImageButton) v.findViewById(R.id.fragment_play_button);
        pauseButton = (ImageButton) v.findViewById(R.id.fragment_pause_button);
        layout = (LinearLayout) v.findViewById(R.id.fragment_layout);

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

        return v;
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
