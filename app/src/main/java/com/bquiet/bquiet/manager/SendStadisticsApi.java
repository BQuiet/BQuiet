package com.bquiet.bquiet.manager;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bquiet.bquiet.model.KeepRealm;
import com.bquiet.bquiet.model.KeepRealmEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gemabeltran on 9/3/17.
 */

public class SendStadisticsApi {

    public SendStadisticsApi() {
    }

    public interface SendStadisticsListener{
        public void onNewSend(boolean response);
    }

    private SendStadisticsListener listener;

    public void setListener (SendStadisticsListener listener) {
        this.listener = listener;
    }

    //TODO poner URL;
    private static final String BASEURL="http://192.168.0.125:8080/markdirect/registrarusuario";
    public void sendStadistics(Context context, final String tok, final String max, final String min,  List<KeepRealm> listRegister){
        String URL = BASEURL;
        /*final String token = tok;
        final String maxim  = max;
        final String minim = min;
        final String media = med;*/
        String registers = "{\"registros\":[";
        Gson gson = new GsonBuilder().create();
        for (int i = 0; i <listRegister.size() ; i++) {
            KeepRealm register = listRegister.get(i);
            KeepRealmEntity realmEntity = KeepRealmEntity.map(register);
            registers = registers + gson.toJson(realmEntity);
            if (i < listRegister.size() -1) {
                registers = registers + ",";
            }

        }
        registers = registers + "]}";


        final String finalRegisters = registers;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("REGISTER_USER", "Todo ha ido bien");
                if(listener !=null){
                    listener.onNewSend(true);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("REGISTER_USER", "Algo ha ido mal" + error);
                if(listener !=null){
                    listener.onNewSend(false);
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                //params.put("Content-Type","application/json");
                params.put("token", tok);
                params.put("max", max);
                params.put("min", min);
                params.put("registers", finalRegisters);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

}
