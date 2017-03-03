package com.bquiet.bquiet.model;


import java.util.Date;

import io.realm.Realm;
import io.realm.RealmObject;

public class Dates extends RealmObject {

    private Date date;

    public Dates(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
