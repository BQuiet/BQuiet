package com.bquiet.bquiet.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.manager.LoginApi;
import com.bquiet.bquiet.manager.SendStadisticsApi;
import com.bquiet.bquiet.model.KeepRealm;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginFragment extends Fragment {

    private EditText userText;
    private EditText passwordText;
    private Button logInButton;
    private Button sendButton;
    private Button logOutButton;
    private LinearLayout loginLinear;
    private LinearLayout logoutLinear;
    private static LoginFragment myFragment;


    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        userText = (EditText) view.findViewById(R.id.fragment_login_user);
        passwordText = (EditText) view.findViewById(R.id.fragment_login_password);
        logInButton = (Button) view.findViewById(R.id.fragment_login_button);
        sendButton = (Button) view.findViewById(R.id.fragment_login_send_button);
        logOutButton = (Button) view.findViewById(R.id.fragment_login_logout_button);
        loginLinear = (LinearLayout) view.findViewById(R.id.linear_login);
        logoutLinear = (LinearLayout) view.findViewById(R.id.linear_logout);
        SharedPreferences prefs =
                getContext().getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        if (token != null){
            logoutLinear.setVisibility(View.VISIBLE);
            loginLinear.setVisibility(View.GONE);
        }else {
            logoutLinear.setVisibility(View.GONE);
            loginLinear.setVisibility(View.VISIBLE);
        }


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Estas dos lineas hay que quitarlas. estan para poder dar al boton de send
                loginLinear.setVisibility(View.GONE);
                logoutLinear.setVisibility(View.VISIBLE);
                LoginApi loginApi = new LoginApi();
                loginApi.consultUser(v.getContext(),userText.getText().toString(), passwordText.getText().toString());
                loginApi.setOnDeckDowloadDataFinish(new LoginApi.UserDonloadDataFinish() {
                    @Override
                    public void responseConsultUser(boolean response, String token) {
                        if (response){
                            SharedPreferences prefs =
                                    getContext().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("Token", token);
                            editor.commit();
                            loginLinear.setVisibility(View.GONE);
                            logoutLinear.setVisibility(View.VISIBLE);

                        }
                    }
                });
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginLinear.setVisibility(View.VISIBLE);
                logoutLinear.setVisibility(View.GONE);
                SharedPreferences prefs =
                        v.getContext().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Token", null);
                editor.commit();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs =
                        getContext().getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
                String token = prefs.getString("Token", null);
                SendStadisticsApi sendStadisticsApi = new SendStadisticsApi();
                sendStadisticsApi.sendStadistics(v.getContext(),token, "50", "10",  extractToRealm());
                sendStadisticsApi.setListener(new SendStadisticsApi.SendStadisticsListener() {
                    @Override
                    public void onNewSend(boolean response) {
                        if (response){
                            deleteRealm();

                            Snackbar.make(getView(), "Los datos se han enviado correctamente", Snackbar.LENGTH_LONG).setActionTextColor(Color.WHITE).show();
                        }else {
                            Snackbar.make(getView(), "No se han podido enviar los datos, intentelo mas tarde", Snackbar.LENGTH_LONG).show();
                            Log.e("Errorrr", "No se han podido enviar los datos");
                        }
                    }
                });
            }
        });
        
        return view;
    }


    public synchronized static Fragment newInstance() {
        if (myFragment == null) {
            myFragment = new LoginFragment();
        }
        return  myFragment;
    }

    public List<KeepRealm> extractToRealm(){

        Realm realm = Realm.getDefaultInstance();
        RealmResults<KeepRealm> registers = realm.where(KeepRealm.class).findAll();

        return registers;
    }

    public void deleteRealm(){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        realm.delete(KeepRealm.class);
    }


}
