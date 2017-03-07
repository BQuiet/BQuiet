package com.bquiet.bquiet.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;

import com.bquiet.bquiet.adapters.MiFragmentPagerAdapter;
import com.bquiet.bquiet.R;

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

        Realm.init(this);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MiFragmentPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);


        /*mTabHost = (FragmentTabHost) findViewById(R.id.activity_main_tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.activity_main__tabcontent);

        mTabHost.addTab(
                mTabHost.newTabSpec("Sonómetro").setIndicator("Sonómetro", null),
                SonometerFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Mi clase").setIndicator("Mi clase", null),
                MyClassFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Niveles").setIndicator("Niveles", null),
                NoiseLevelFragment.class, null);
        mTabHost.addTab(

                mTabHost.newTabSpec("Estadísticas").setIndicator("Estadísticas", null),
                GraphicsFragment.class, null);

                mTabHost.newTabSpec("Graphics").setIndicator("Graphics", null),
                GraphicsFragment.class, null);*/


    }

}