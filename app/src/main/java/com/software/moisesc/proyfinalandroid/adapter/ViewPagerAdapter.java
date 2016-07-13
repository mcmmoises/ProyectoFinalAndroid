package com.software.moisesc.proyfinalandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.software.moisesc.proyfinalandroid.PostFragment;
import com.software.moisesc.proyfinalandroid.UserFragment;

/**
 * Created by Pablo on 6/15/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PostFragment();
            case 1:
                return new UserFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
