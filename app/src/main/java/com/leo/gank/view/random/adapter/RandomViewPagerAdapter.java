package com.leo.gank.view.random.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.leo.gank.view.random.random_list.RandomListFragment;

/**
 * Created by leo on 2016/4/26
 * Function
 */
public class RandomViewPagerAdapter extends FragmentStatePagerAdapter {
    String[] strs;

    public RandomViewPagerAdapter(FragmentManager fm, String[] strs) {
        super(fm);
        this.strs = strs;
    }

    @Override
    public Fragment getItem(int position) {
        return RandomListFragment.getInstance(strs[position]);
    }

    @Override
    public int getCount() {
        return strs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strs[position];
    }


}
