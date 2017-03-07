package com.bquiet.bquiet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bquiet.bquiet.R;

public class LoginFragment extends Fragment {

    EditText userText;
    EditText passwordText;
    Button logInButton;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        userText = (EditText) view.findViewById(R.id.fragment_login_user);
        passwordText = (EditText) view.findViewById(R.id.fragment_login_password);
        logInButton = (Button) view.findViewById(R.id.fragment_login_button);
        
        return view;
    }

}
