package com.bquiet.bquiet.manager;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;

/**
 * Created by gemabeltran on 9/3/17.
 */

public class LoginApi {

    public static final  String URL="https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";


    public  interface UserDonloadDataFinish {
        public void responseConsultUser(boolean response, String token);
    }

    private UserDonloadDataFinish listener;

    public void setOnDeckDowloadDataFinish(UserDonloadDataFinish listener) {
        this.listener = listener;
    }

    public void consultUser(Context context, String user, String password){

        RequestQueue queue = Volley.newRequestQueue(context);

        Log.d("URL", URL);

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //all ok

                Log.d("RESPONSE", response);
                parseJSON(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //tenemos un problema
                Log.e("HORROR", "Connection went to shit to the tracks");
            }
        });

        queue.add(request);
    }

    private void parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        Reader reader = new StringReader(response);
        LoginResponse loginResponse = gson.fromJson(reader, LoginResponse.class);
        Log.d("RESPONSE", loginResponse.toString());

        if (listener!=null){
            String token = loginResponse.getToken();
            listener.responseConsultUser(true, "asdasda");
        }


    }
}
