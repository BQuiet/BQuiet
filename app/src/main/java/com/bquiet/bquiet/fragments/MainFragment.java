package com.bquiet.bquiet.fragments;


import android.content.Context;
import android.content.SharedPreferences;
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

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.manager.RecorderManager;
//import com.bquiet.bquiet.model.Dates;
//import com.bquiet.bquiet.model.NoiseList;
import com.bquiet.bquiet.model.Constants;
import com.github.anastr.speedviewlib.Speedometer;

import java.util.Date;

//import io.realm.Realm;
//import io.realm.RealmResults;

import static android.view.View.GONE;

public class MainFragment extends Fragment {

    public static final int MEDIUM_NOISE = 80;
    public static final int LOW_NOISE = 40;

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
    boolean started = false;
    long myStartDate;

    int lowMargin;
    int mediumMargin;

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

        SharedPreferences preferences = getActivity().getSharedPreferences("preferences", 0);
        lowMargin = preferences.getInt("lowMargin", Constants.DEFAULT_LOW_LABEL_SPEEDOMETRE);
        mediumMargin = preferences.getInt("mediumMargin", Constants.DEFAULT_MEDIUM_LABEL_SPEEDOMETRE);

        speedometer.setLowSpeedPercent(lowMargin);
        speedometer2.setLowSpeedPercent(lowMargin);
        speedometer3.setLowSpeedPercent(lowMargin);
        speedometer4.setLowSpeedPercent(lowMargin);

        speedometer.setMediumSpeedPercent(mediumMargin);
        speedometer2.setMediumSpeedPercent(mediumMargin);
        speedometer3.setMediumSpeedPercent(mediumMargin);
        speedometer4.setMediumSpeedPercent(mediumMargin);

        speedometer.setWithTremble(speedometreWithTremble);
        speedometer2.setWithTremble(speedometreWithTremble);
        speedometer3.setWithTremble(speedometreWithTremble);
        speedometer4.setWithTremble(speedometreWithTremble);


        scrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.setInAnimation(view.getContext(), R.anim.fadein);
                scrollView.showNext();
            }
        });

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
                        speedometer3.speedTo((float) spl);
                        speedometer4.speedTo((float) spl);

                        float dBelios = speedometer.getSpeed();
                        String realReader = String.format("%.0f dB", dBelios);
                        dB.setText(realReader);
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

        Date actualDate = new Date();
        //Realm realm = Realm.getDefaultInstance();

        if (noiseLevel < lowMargin) {
            layout.setBackgroundResource(R.color.colorLowNoise);
            stopAlarm();
            state.setText(R.string.low_state);
            /*
            realm.beginTransaction();
            NoiseList.setNoiseListPoint(noiseLevel);
            Dates.setRegistrationDate(Date);
            realm.commitTransaction();


            RealmResults<Dates> dates = realm.where(Dates.class).findAllSorted("registrationDate");
            RealmResults<NoiseList> noiseLists = realm.where(NoiseList.class).findAllSorted("noiseListPoint");
            */

        } else if (noiseLevel > lowMargin && noiseLevel < mediumMargin) {
            layout.setBackgroundResource(R.color.colorMediumNoise);
            stopAlarm();
            started = false;
            state.setText(R.string.normal_state);
            /*
            realm.beginTransaction();
            NoiseList.setNoiseListPoint(noiseLevel);
            realm.commitTransaction();

            RealmResults<Dates> dates = realm.where(Dates.class).findAllSorted("registrationDate");
            RealmResults<NoiseList> noiseLists = realm.where(NoiseList.class).findAllSorted("noiseListPoint");
            */

        } else if (noiseLevel > mediumMargin) {
            layout.setBackgroundResource(R.color.colorHighNoise);
            state.setText(R.string.state_high);
            /*
            realm.beginTransaction();
            NoiseList.setNoiseListPoint(noiseLevel);
            realm.commitTransaction();

            RealmResults<Dates> dates = realm.where(Dates.class).findAllSorted("registrationDate");
            RealmResults<NoiseList> noiseLists = realm.where(NoiseList.class).findAllSorted("noiseListPoint");
            */

            if (!started) {
                myStartDate = actualDate.getTime();
                started = true;
            }else {
                if ((actualDate.getTime() - myStartDate) > 2000 && 10000 > (actualDate.getTime() - myStartDate)) {
                    soundAlarm(getContext());
                }
            }
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





