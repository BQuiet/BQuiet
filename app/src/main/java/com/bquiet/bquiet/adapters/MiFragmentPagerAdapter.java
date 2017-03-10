package com.bquiet.bquiet.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bquiet.bquiet.fragments.AboutFragment;
import com.bquiet.bquiet.fragments.LoginFragment;
import com.bquiet.bquiet.fragments.NoiseLevelFragment;
import com.bquiet.bquiet.fragments.SonometerFragment;


public class MiFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] =
            new String[] { "   Sonómetro   ", "   Niveles   ", "   Log/Send   ", "   Equipo   "};

    public MiFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment f  = null; // = (SonometerFragment) SonometerFragment.newInstance();

        switch(position) {
            case 0:
                f =  SonometerFragment.newInstance();
                break;
            case 1:
                f = NoiseLevelFragment.newInstance();
                break;
            case 2:
                f = LoginFragment.newInstance();
                break;
            case 3:
                f = AboutFragment.newInstance();
                break;
            case 4:

                break;
            case 5:

                break;
        }

        return f;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
