package com.bquiet.bquiet.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;

import com.bquiet.bquiet.R;
import com.bquiet.bquiet.adapters.MiFragmentPagerAdapter;
import com.bquiet.bquiet.fragments.SonometerFragment;

import io.realm.Realm;


public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;
    private SonometerFragment sonometerFragment;

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

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final MiFragmentPagerAdapter adapter = new MiFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    sonometerFragment = (SonometerFragment) adapter.getItem(0);
                    sonometerFragment.refresh();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}