package com.bquiet.bquiet.model;

import java.util.Date;

import io.realm.RealmObject;


public class NoiseList extends RealmObject {
    public NoiseList getNoiseList() {
        return noiseList;
    }

    public void setNoiseList(NoiseList noiseList) {
        this.noiseList = noiseList;
    }

    private NoiseList noiseList;

    public NoiseList(){

    }
}
