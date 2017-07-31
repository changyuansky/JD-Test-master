package com.sxjs.jd.composition.main.Order;

import com.sxjs.common.bean.MyOrderInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class Detail {
    int orderid;
   MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean Infos;
    List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> Goodslist;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean getInfos() {
        return Infos;
    }

    public void setInfos(MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean infos) {
        Infos = infos;
    }

    public List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> getGoodslist() {
        return Goodslist;
    }

    public void setGoodslist(List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> goodslist) {
        Goodslist = goodslist;
    }
}
