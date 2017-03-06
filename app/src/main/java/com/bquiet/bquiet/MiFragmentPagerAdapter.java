package com.bquiet.bquiet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bquiet.bquiet.fragments.GraphicsFragment;
import com.bquiet.bquiet.fragments.MainFragment;
import com.bquiet.bquiet.fragments.MyClassFragment;
import com.bquiet.bquiet.fragments.NoiseLevelFragment;

/**
 * Created by gemabeltran on 6/3/17.
 */

public class MiFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 6;
    private String tabTitles[] =
            new String[] { "   NOISEMETRE   ", "   MY CLASS   ", "   NOISE LEVEL   ", "   GRAPHICS   ", "   Tab Cinco   ", "   Tab Seis   "};

    public MiFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment f = (MainFragment) MainFragment.newInstance();

        switch(position) {
            case 0:
                f =  MainFragment.newInstance();
                break;
            case 1:
                f = MyClassFragment.newInstance();
                break;
            case 2:
                f = NoiseLevelFragment.newInstance();
                break;
            case 3:
                f = GraphicsFragment.newInstance();
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
