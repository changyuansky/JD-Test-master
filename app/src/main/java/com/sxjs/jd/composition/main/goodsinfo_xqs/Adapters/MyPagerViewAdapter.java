package com.sxjs.jd.composition.main.goodsinfo_xqs.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class MyPagerViewAdapter extends FragmentPagerAdapter {
    List<String> strings;
    List<Fragment> fragmentList;
    public MyPagerViewAdapter(FragmentManager fm,List<String> strings,List<Fragment> fragments) {
        super(fm);
        this.fragmentList=fragments;
        this.strings=strings;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
