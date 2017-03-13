package com.bquiet.bquiet.model;


public class KeepRealmEntity  {
    private long date;
    private float spl;

    public KeepRealmEntity() {
    }

    public KeepRealmEntity(long date, float spl) {
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

    public static KeepRealmEntity map(KeepRealm kr) {
        KeepRealmEntity kre = new KeepRealmEntity(kr.getDate(), kr.getSpl());
        return kre;
    }

}
