package com.bquiet.bquiet.manager;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gemabeltran on 9/3/17.
 */

public class LoginResponse {

    @SerializedName("token") private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
