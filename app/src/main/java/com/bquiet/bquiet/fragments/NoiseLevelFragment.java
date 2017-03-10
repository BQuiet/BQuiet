package com.bquiet.bquiet.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.model.Constants;
import com.github.anastr.speedviewlib.Speedometer;

import pl.polak.clicknumberpicker.ClickNumberPickerListener;
import pl.polak.clicknumberpicker.ClickNumberPickerView;
import pl.polak.clicknumberpicker.PickerClickType;

public class NoiseLevelFragment extends Fragment {

    Speedometer speedometer;

    ClickNumberPickerView lowClickNumberPickerView;
    ClickNumberPickerView highClickNumberPickerView;
    private int lowMargin;
    private int mediumMargin;
    private static NoiseLevelFragment myFragment;


    public NoiseLevelFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noise_level, container, false);

        speedometer = (Speedometer) view.findViewById(R.id.fragment_noise_level_speedometer);

        lowClickNumberPickerView = (ClickNumberPickerView) view.findViewById(R.id.fragment_noise_level_low_picker);
        highClickNumberPickerView = (ClickNumberPickerView) view.findViewById(R.id.fragment_noise_level_high_picker);

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        lowMargin = preferences.getInt("lowMargin", Constants.DEFAULT_LOW_LABEL_SPEEDOMETRE);
        mediumMargin = preferences.getInt("mediumMargin", Constants.DEFAULT_MEDIUM_LABEL_SPEEDOMETRE);

        lowClickNumberPickerView.setPickerValue(lowMargin);
        highClickNumberPickerView.setPickerValue(mediumMargin);

        speedometer.setLowSpeedPercent(lowMargin);
        speedometer.setMediumSpeedPercent(mediumMargin);

        lowClickNumberPickerView.setClickNumberPickerListener(new ClickNumberPickerListener() {
            @Override
            public void onValueChange(float previousValue, float currentValue, PickerClickType pickerClickType) {
                if(currentValue < mediumMargin) {
                    lowMargin = (int) currentValue;
                    speedometer.setLowSpeedPercent((int) currentValue);

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("lowMargin", (int) currentValue);
                    editor.commit();
                } else {
                    Log.d("error", "" + mediumMargin + " " + lowClickNumberPickerView.getValue());
                    lowClickNumberPickerView.setPickerValue(mediumMargin -1);
                }
                lowClickNumberPickerView.recomputeViewAttributes(lowClickNumberPickerView);
            }
        });

        highClickNumberPickerView.setClickNumberPickerListener(new ClickNumberPickerListener() {
            @Override
            public void onValueChange(float previousValue, float currentValue, PickerClickType pickerClickType) {
                if(currentValue > lowMargin) {
                    mediumMargin = (int) currentValue;
                    speedometer.setMediumSpeedPercent((int) currentValue);

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("mediumMargin", (int) currentValue);
                    editor.commit();
                } else {
                    highClickNumberPickerView.setPickerValue(lowMargin + 1);
                }
            }
        });

        return view;

    }
    public synchronized static Fragment newInstance() {
        if (myFragment == null) {
            myFragment = new NoiseLevelFragment();
        }
        return myFragment;

    }

}
