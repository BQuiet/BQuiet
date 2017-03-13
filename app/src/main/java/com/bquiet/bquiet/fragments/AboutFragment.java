package com.bquiet.bquiet.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bquiet.bquiet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    private static AboutFragment myFragment;
    ImageView linkedinCristina;
    ImageView gitHubCristina;
    TextView  linkedinCristinat;
    TextView  gitHubCristinat;

    ImageView linkedinCazalla;
    ImageView gitHubCazalla;
    TextView  linkedinCazallat;
    TextView gitHubCazallat;

    ImageView linkedinElias;
    ImageView gitHubElias;
    TextView  linkedinEliast;
    TextView  gitHubEliast;

    ImageView linkedinAlberto;
    ImageView gitHubAlberto;
    TextView  linkedinAlbertot;
    TextView  gitHubAlbertot;

    ImageView linkedinSaul;
    ImageView gitHubSaul;
    TextView  linkedinSault;
    TextView  gitHubSault;

    ImageView linkedinEmilio;
    ImageView gitHubEmilio;
    TextView  linkedinEmiliot;
    TextView  gitHubEmiliot;

    ImageView linkedinAntonio;
    ImageView gitHubAntonio;
    TextView  linkedinAntoniot;
    TextView  gitHubAntoniot;

    TextView  gitHubRobot;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        linkedinCristina= (ImageView) view.findViewById(R.id.card_view_linkedin_cristina);
        gitHubCristina= (ImageView) view.findViewById(R.id.card_view_github_cristina);
        linkedinCristinat=(TextView) view.findViewById(R.id.linkedin_cristina_tarjeta);
        gitHubCristinat=(TextView) view.findViewById(R.id.git_cristina_tarjeta);

        linkedinCazalla= (ImageView) view.findViewById(R.id.card_view_linkedin_cazalla);
        gitHubCazalla= (ImageView) view.findViewById(R.id.card_view_github_cazalla);
        linkedinCazallat=(TextView) view.findViewById(R.id.linkedin_cazalla_tarjeta);
        gitHubCazallat=(TextView) view.findViewById(R.id.git_cazalla_tarjeta);

        linkedinElias= (ImageView) view.findViewById(R.id.card_view_linkedin_elias);
        gitHubElias= (ImageView) view.findViewById(R.id.card_view_github_elias);
        linkedinEliast=(TextView) view.findViewById(R.id.linkedin_elias_tarjeta);
        gitHubEliast=(TextView) view.findViewById(R.id.git_elias_tarjeta);

        linkedinAlberto= (ImageView) view.findViewById(R.id.card_view_linkedin_alberto);
        gitHubAlberto= (ImageView) view.findViewById(R.id.card_view_github_alberto);
        linkedinAlbertot=(TextView) view.findViewById(R.id.linkedin_alberto_tarjeta);
        gitHubAlbertot=(TextView) view.findViewById(R.id.git_alberto_tarjeta);

        linkedinSaul= (ImageView) view.findViewById(R.id.card_view_linkedin_saul);
        gitHubSaul= (ImageView) view.findViewById(R.id.card_view_github_saul);
        linkedinSault=(TextView) view.findViewById(R.id.linkedin_saul_tarjeta);
        gitHubSault=(TextView) view.findViewById(R.id.git_saul_tarjeta);

        linkedinEmilio= (ImageView) view.findViewById(R.id.card_view_linkedin_emilio);
        gitHubEmilio= (ImageView) view.findViewById(R.id.card_view_github_emilio);
        linkedinEmiliot=(TextView) view.findViewById(R.id.linkedin_emilio_tarjeta);
        gitHubEmiliot=(TextView) view.findViewById(R.id.git_emilio_tarjeta);

        linkedinAntonio= (ImageView) view.findViewById(R.id.card_view_linkedin_antonio);
        gitHubAntonio= (ImageView) view.findViewById(R.id.card_view_github_antonio);
        linkedinAntoniot=(TextView) view.findViewById(R.id.linkedin_antonio_tarjeta);
        gitHubAntoniot=(TextView) view.findViewById(R.id.git_antonio_tarjeta);



        gitHubRobot=(TextView) view.findViewById(R.id.git_robonautas_tarjeta);

        linkedinCristina.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/cristinaperezmoreno/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubCristina.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/pemCristina");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinCristinat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/cristinaperezmoreno/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubCristinat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/pemCristina");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinCazalla.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/antonio-jesus-cazalla");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubCazalla.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/cazallau");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinCazallat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/antonio-jesus-cazalla");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubCazallat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/cazallau");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinElias.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/eliasmuol");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubElias.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/eliasmuol");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinEliast.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/eliasmuol");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubEliast.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/eliasmuol");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinAlberto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/alberto-martinez-quintana-b1306b130/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubAlberto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/Alber81");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinAlbertot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/alberto-martinez-quintana-b1306b130/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubAlbertot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/Alber81");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        linkedinSaul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/saulmarinquerido/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubSaul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/smappdev");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinSault.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/saulmarinquerido/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubSault.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/smappdev");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinEmilio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/emiriera/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubEmilio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/EmiMLG");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinEmiliot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/emiriera/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubEmiliot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/EmiMLG");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        linkedinAntonio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/angonmel/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubAntonio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/angonmel");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        linkedinAntoniot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/angonmel/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitHubAntoniot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/angonmel");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



        gitHubRobot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.robonautas.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        return view;
    }

    public synchronized static Fragment newInstance() {
        if (myFragment == null) {
            myFragment = new AboutFragment();
        }
        return myFragment;

    }

}
