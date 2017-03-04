package com.bquiet.bquiet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bquiet.bquiet.R;
import com.github.anastr.speedviewlib.Speedometer;

import pl.polak.clicknumberpicker.ClickNumberPickerListener;
import pl.polak.clicknumberpicker.ClickNumberPickerView;
import pl.polak.clicknumberpicker.PickerClickType;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoiseLevelFragment extends Fragment {

    Speedometer speedometer;

    ClickNumberPickerView lowClickNumberPickerView;
    ClickNumberPickerView highClickNumberPickerView;

    public NoiseLevelFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noise_level, container, false);

        speedometer = (Speedometer) view.findViewById(R.id.fragment_noise_level_speedometer);

        lowClickNumberPickerView = (ClickNumberPickerView) view.findViewById(R.id.fragment_noise_level_low_picker);
        highClickNumberPickerView = (ClickNumberPickerView) view.findViewById(R.id.fragment_noise_level_high_picker);

        lowClickNumberPickerView.setPickerValue(MainFragment.LOW_NOISE);
        highClickNumberPickerView.setPickerValue(MainFragment.MEDIUM_NOISE);

        speedometer.setLowSpeedPercent(MainFragment.LOW_NOISE);
        speedometer.setMediumSpeedPercent(MainFragment.MEDIUM_NOISE);

        lowClickNumberPickerView.setClickNumberPickerListener(new ClickNumberPickerListener() {
            @Override
            public void onValueChange(float previousValue, float currentValue, PickerClickType pickerClickType) {
                speedometer.setLowSpeedPercent((int) currentValue);
            }
        });

        highClickNumberPickerView.setClickNumberPickerListener(new ClickNumberPickerListener() {
            @Override
            public void onValueChange(float previousValue, float currentValue, PickerClickType pickerClickType) {
                speedometer.setMediumSpeedPercent((int) currentValue);
            }
        });

        return view;

    }

}
