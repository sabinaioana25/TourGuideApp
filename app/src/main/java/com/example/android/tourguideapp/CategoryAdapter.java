package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sabina on 6/12/2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

//    private String tabNames[] ={"Sights", "What's on", "Food + drink", "Shopping"};

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

//        Log.i("Tab Position", String.valueOf(position));
        switch (position) {
            case 0:
                //Sights fragment activity
                return new SightsFragment();
            case 1:
                //New events fragment activity
                return new NewsFragment();
            case 2:
                //Food places fragment activity
                return new FoodFragment();
            case 3:
                //Shopping places fragment activity
                return new ShopFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab_sight);
            case 1:
                return mContext.getString(R.string.tab_new);
            case 2:
                return mContext.getString(R.string.tab_food);
            case 3: return mContext.getString(R.string.tab_shop);
        }
        return null; }
}

