package com.sxjs.jd.composition.main.goodsinfo_xqs.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;

import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.base.BaseFragment;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.goodsinfo_xqs.Adapters.PinRecyclerAdapter;
import com.sxjs.jd.composition.main.goodsinfo_xqs.MyData.GoodsInfoInterface_pin;
import com.sxjs.jd.composition.main.goodsinfo_xqs.MyData.MyGoodsinfo;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */

public class PinFragment extends BaseFragment implements GoodsInfoInterface_pin {
    //商品详情
    private  PopupWindow popupWindow_yixuan;
    private  View view;
    private  String imageurl;
    private  String goods_img;
    private  String goods_thumb;
    private  String goods_brief;
    private  String keywords;
    private  int market_price;
    private  String goods_number;
    private  int click_count;
    private  String goods_name;
    private  String goods_sn;
      //good_sn  商品的唯一货号
    private  int[] imgs = new int[]{R.mipmap.laolishi_1, R.mipmap.laolishi2, R.mipmap.laolishi_3, R.mipmap.laolishi_4};
    private  List<ImageView> imageViews;
    private  List<ImageView> mimageviews;
    private  RecyclerView recyclerView;
    private  List<HomeWares.ItemsBean.ItemListBean> GoodsInfoList;
    private  int number = 0;
      //手势识别器
    private  GestureDetector mDetector;
    private int goodsId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pin_fragment, null);
        init();

        MyGoodsinfo myGoodsinfo = new MyGoodsinfo(this,GlobalAppComponent.getAppComponent().getDataManager());
        myGoodsinfo.getServiceGoodsInfo(goodsId);//传入goodsId
        recyclerView = view.findViewById(R.id.pin_RLV);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //设置商品的goodsId
    public void setGoodsId(int goodsId){
        this.goodsId=goodsId;
    }

    public void init() {
        imageViews = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imgs[i]);
            imageViews.add(imageView);
        }
        mimageviews = new ArrayList<>();
        for (int i = 0; i < 5; i++) {


            ImageView mimageView = new ImageView(getActivity());
            Glide.with(getActivity())
                    .load("http://img02.sogoucdn.com/app/a/100520024/5cf8df29532167e20f1d7ecc2528f959")
                    .into(mimageView);
            mimageviews.add(mimageView);
        }

    }

    @Override
    public void getgoodsinfo_pin(HomeWares goodsPinInfo) {
        GoodsInfoList=new ArrayList<>();
        GoodsInfoList=goodsPinInfo.getItems().get(0).getItemList();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new PinRecyclerAdapter(getActivity(), imageViews,GoodsInfoList));
    }

}
