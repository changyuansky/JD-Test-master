package com.sxjs.jd.composition.main.classifyicon_zy.TablayoutUtils;

import com.sxjs.common.bean.HomeWares;

import java.util.Comparator;

/**
 * Created by Administrator on 2017/7/26.
 */

public class BeanComparator implements Comparator<HomeWares.ItemsBean.ItemListBean> {
    @Override
    public int compare(HomeWares.ItemsBean.ItemListBean t1, HomeWares.ItemsBean.ItemListBean t2) {
        int num = t1.getShopPrice().compareTo(t2.getShopPrice());
        return num;
    }
}
