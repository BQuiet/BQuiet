package com.bquiet.bquiet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bquiet.bquiet.R;

import static android.view.View.GONE;

public class LoginFragment extends Fragment {

    EditText userText;
    EditText passwordText;
    Button logInButton;
    Button sendButton;
    Button logOutButton;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        userText = (EditText) view.findViewById(R.id.fragment_login_user);
        passwordText = (EditText) view.findViewById(R.id.fragment_login_password);
        logInButton = (Button) view.findViewById(R.id.fragment_login_button);
        sendButton = (Button) view.findViewById(R.id.fragment_login_send_button);
        logOutButton = (Button) view.findViewById(R.id.fragment_login_logout_button);

        logInButton.setVisibility(View.VISIBLE);
        userText.setVisibility(View.VISIBLE);
        passwordText.setVisibility(View.VISIBLE);
        sendButton.setVisibility(GONE);
        logOutButton.setVisibility(GONE);


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: Meter esto en el metodo de comprobacion del login o token
                logInButton.setVisibility(GONE);
                userText.setVisibility(GONE);
                passwordText.setVisibility(GONE);
                sendButton.setVisibility(View.VISIBLE);
                logOutButton.setVisibility(View.VISIBLE);


            }
        });
        
        return view;
    }

    public static Fragment newInstance() {
        LoginFragment myFragment = new LoginFragment();
        return myFragment;

    }

}
