package com.sxjs.jd.composition.main.goodsinfo_xqs.FragmentDetectorListener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/7/16.
 */

public class FragmentDetectorListenter extends Fragment {
    GestureDetector mDetector;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetector=new GestureDetector(getActivity(),new GestureDetector.SimpleOnGestureListener(){
            @Override
            //Fling  撇  扔  e1 表示滑动的起点   e2 表示滑动的终点
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e2.getRawX()-e1.getRawX()>200)//跳到上一页  getX()相对控件的坐标   getRowX()相对整个屏幕的坐标
                {
                    //向右滑

                }
                if (e1.getRawX()-e2.getRawX()>200)
                {
                    //向左滑

                }
                return true;
            }
        });
    }
}
