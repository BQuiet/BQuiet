package com.bquiet.bquiet.model;


import java.util.Date;

import io.realm.RealmObject;

public class KeepRealm extends RealmObject {
    private Date date = new Date();
    private float spl;

    public KeepRealm() {
    }

    public KeepRealm(Date date, float spl) {
        this.date = date;
        this.spl = spl;
    }

    public float getSpl() {
        return spl;
    }

    public void setSpl(float spl) {
        this.spl = spl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
