package com.bquiet.bquiet.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    public NoiseLevelFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noise_level, container, false);

        speedometer = (Speedometer) view.findViewById(R.id.fragment_noise_level_speedometer);

        lowClickNumberPickerView = (ClickNumberPickerView) view.findViewById(R.id.fragment_noise_level_low_picker);
        highClickNumberPickerView = (ClickNumberPickerView) view.findViewById(R.id.fragment_noise_level_high_picker);

        SharedPreferences preferences = getActivity().getSharedPreferences("preferences", 0);
        int lowMargin = preferences.getInt("lowMargin", Constants.DEFAULT_LOW_LABEL_SPEEDOMETRE);
        int mediumMargin = preferences.getInt("mediumMargin", Constants.DEFAULT_MEDIUM_LABEL_SPEEDOMETRE);

        lowClickNumberPickerView.setPickerValue(lowMargin);
        highClickNumberPickerView.setPickerValue(mediumMargin);

        speedometer.setLowSpeedPercent(lowMargin);
        speedometer.setMediumSpeedPercent(mediumMargin);

        lowClickNumberPickerView.setClickNumberPickerListener(new ClickNumberPickerListener() {
            @Override
            public void onValueChange(float previousValue, float currentValue, PickerClickType pickerClickType) {
                speedometer.setLowSpeedPercent((int) currentValue);

                SharedPreferences preferences = getActivity().getSharedPreferences("preferences", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("lowMargin", (int) currentValue);
                editor.commit();
            }
        });

        highClickNumberPickerView.setClickNumberPickerListener(new ClickNumberPickerListener() {
            @Override
            public void onValueChange(float previousValue, float currentValue, PickerClickType pickerClickType) {
                speedometer.setMediumSpeedPercent((int) currentValue);

                SharedPreferences preferences = getActivity().getSharedPreferences("preferences", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("mediumMargin", (int) currentValue);
                editor.commit();
            }
        });

        return view;

    }
    public static Fragment newInstance() {
        NoiseLevelFragment myFragment = new NoiseLevelFragment();
        return myFragment;

    }

}
