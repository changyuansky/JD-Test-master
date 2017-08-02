package com.sxjs.jd.composition.main.goodsinfo_xqs.Fragments;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */

public class ViewPagerAdapter extends PagerAdapter {
    Activity activity;
    List<ImageView> imageViews;
    public ViewPagerAdapter(Activity activity,List<ImageView> imageViews)
    {
        this.activity=activity;
        this.imageViews=imageViews;
    }
    @Override
    public int getCount() {
        return imageViews.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }
}
