package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sabina on 6/12/2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private String tabNames[] = new String[]{"Sights", "What's on", "Food + drink", "Shopping"};

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightsFragment();
        } else if (position == 1) {
            return new NewsFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else {
            return new ShopFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }
}
