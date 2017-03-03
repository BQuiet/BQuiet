package com.bquiet.bquiet.model;


import java.util.Date;

import io.realm.RealmObject;

public class Dates extends RealmObject {

    private Date registrationDate;
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }



    public Dates(){

    }



}
