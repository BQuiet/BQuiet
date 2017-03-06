package com.bquiet.bquiet.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuInflater;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.fragments.GraphicsFragment;
import com.bquiet.bquiet.fragments.MainFragment;
import com.bquiet.bquiet.fragments.MyClassFragment;
import com.bquiet.bquiet.fragments.NoiseLevelFragment;

import io.realm.Realm;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubquiet, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost) findViewById(R.id.activity_main_tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.activity_main__tabcontent);

        mTabHost.addTab(
                mTabHost.newTabSpec("Noisemetre").setIndicator("Noisemetre", null),
                MainFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("My Class").setIndicator("My Class", null),
                MyClassFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Noise Level").setIndicator("Noise Level", null),
                NoiseLevelFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Graphics").setIndicator("Graphics", null),
                GraphicsFragment.class, null);

    }

}