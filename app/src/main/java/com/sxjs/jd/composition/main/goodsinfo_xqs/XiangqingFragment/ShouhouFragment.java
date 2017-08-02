package com.sxjs.jd.composition.main.goodsinfo_xqs.XiangqingFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxjs.jd.R;


/**
 * Created by Administrator on 2017/7/16.
 */

public class ShouhouFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.qing_fragment_shouhou,null);
        return view;
    }
}
