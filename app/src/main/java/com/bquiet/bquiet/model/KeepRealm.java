package com.bquiet.bquiet.model;


import io.realm.RealmObject;

public class KeepRealm extends RealmObject {
    private long date;
    private float spl;

    public KeepRealm() {
    }

    public KeepRealm(long date, float spl) {
        this.date = date;
        this.spl = spl;
    }

    public float getSpl() {
        return spl;
    }

    public void setSpl(float spl) {
        this.spl = spl;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }


}
