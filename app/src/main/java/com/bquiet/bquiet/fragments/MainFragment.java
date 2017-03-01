package com.bquiet.bquiet.fragments;


import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import android.widget.ViewSwitcher;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.manager.RecorderManager;
import com.github.anastr.speedviewlib.Speedometer;

import static android.view.View.GONE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public static final int MEDIUM_NOISE = 70;
    public static final int LOW_NOISE = 10;


    private Speedometer speedometer;
    private Speedometer speedometer2;
    private Speedometer speedometer3;
    private Speedometer speedometer4;

    private ImageButton playButton;
    private ImageButton pauseButton;
    private RelativeLayout layout;
    private TextView dB;
    private TextView state;
    private ViewAnimator scrollView;

    private boolean speedometreWithTremble = false;

    Animation slide_in_left, slide_out_right;
    RecorderManager recorderManager;
    RecorderManager.Ear ear;
    MediaPlayer mp;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        speedometer = (Speedometer) v.findViewById(R.id.speedView);
        speedometer2 = (Speedometer) v.findViewById(R.id.awesomeSpeedometer);
        speedometer3 = (Speedometer) v.findViewById(R.id.tubeSpeedometer);
        speedometer4 = (Speedometer) v.findViewById(R.id.deluxeSpeedView);
        playButton = (ImageButton) v.findViewById(R.id.fragment_play_button);
        pauseButton = (ImageButton) v.findViewById(R.id.fragment_pause_button);
        layout = (RelativeLayout) v.findViewById(R.id.fragment_relativeLayout);
        state = (TextView) v.findViewById(R.id.fragment_state_text_view);
        dB = (TextView) v.findViewById(R.id.fragment_db_text_view);
        scrollView = (ViewAnimator) v.findViewById(R.id.scroll);

        scrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.setInAnimation(view.getContext(), R.anim.fadein);
                scrollView.showNext();
            }
        });

        scrollView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                scrollView.setInAnimation(view.getContext(), R.anim.fadein);
                scrollView.showPrevious();
                return true;
            }
        });


        speedometer.setWithTremble(speedometreWithTremble);
        speedometer.setLowSpeedPercent(LOW_NOISE);
        speedometer.setMediumSpeedPercent(MEDIUM_NOISE);

        playButton.setVisibility(View.VISIBLE);
        pauseButton.setVisibility(GONE);





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
                        speedometer2.speedTo((float) spl);
                        dB.setText("" + speedometer.getSpeed());
                        speedometer3.speedTo((float) spl);
                        speedometer4.speedTo((float) spl);
                    }
                });
                recorderManager.setListening(true);
                //ear.cancel(recorderManager.isListening());
                ear.execute();

                playButton.setPressed(true);
                playButton.setVisibility(GONE);
                pauseButton.setVisibility(View.VISIBLE);

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recorderManager.setListening(false);
                speedometer.speedTo(0.0f);
                recorderManager.stopMediaRecorder();
                ear.cancel(recorderManager.isListening());

                pauseButton.setPressed(true);
                playButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(GONE);
            }
        });

        return v;
    }

    private void changeBackgroundImage(float noiseLevel) {
        if (noiseLevel < LOW_NOISE) {
            layout.setBackgroundResource(R.color.colorLowNoise);
            stopAlarm();
            state.setText(R.string.low_state);
        } else if (noiseLevel > LOW_NOISE && noiseLevel < MEDIUM_NOISE) {
            layout.setBackgroundResource(R.color.colorMediumNoise);
            stopAlarm();
            state.setText(R.string.normal_state);

        } else if (noiseLevel > MEDIUM_NOISE) {
            layout.setBackgroundResource(R.color.colorHighNoise);
            soundAlarm(getContext());
            state.setText(R.string.state_high);

        }
    }

    private void soundAlarm(Context context){
        mp = MediaPlayer.create(context, R.raw.alarm);
        mp.start();
    }

    private void stopAlarm(){
        if(mp !=null){
            mp.release();
            mp = null;
        }
    }

}





