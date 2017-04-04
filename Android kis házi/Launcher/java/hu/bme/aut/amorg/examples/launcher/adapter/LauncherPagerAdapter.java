package hu.bme.aut.amorg.examples.launcher.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hu.bme.aut.amorg.examples.launcher.fragments.ApplicationsFragment;
import hu.bme.aut.amorg.examples.launcher.fragments.DialerFragment;

public class LauncherPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 2;

    public LauncherPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new DialerFragment();
            case 1: return new ApplicationsFragment();
            default: return new ApplicationsFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}