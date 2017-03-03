package com.bquiet.bquiet.model;

import java.util.Date;

import io.realm.RealmObject;


public class NoiseList extends RealmObject {


    public NoiseList getNoiseListPoint() {
        return noiseListPoint;
    }

    public void setNoiseListPoint(NoiseList noiseListPoint) {
        this.noiseListPoint = noiseListPoint;
    }

    private NoiseList noiseListPoint;

    public NoiseList(){

    }
}
