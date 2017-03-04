package com.bquiet.bquiet.model;

import java.util.Date;

import io.realm.RealmObject;


public class NoiseList extends RealmObject {
    private static float noiseListPoint;

    public NoiseList(){

    }
    public static float getNoiseListPoint() {
        return noiseListPoint;
    }

    public static void setNoiseListPoint(float noiseListPoint) {
        NoiseList.noiseListPoint = noiseListPoint;
    }
}









