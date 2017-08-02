package com.sxjs.jd.composition.main.goodsinfo_xqs.MyData;

import android.util.Log;

import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.model.DataManager;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Administrator on 2017/7/22.
 */

public class MyGoodsinfo {
    GoodsInfoInterface goodsInfoInterface;
    GoodsInfoInterface_pin goodsInfoInterface_pin;
    ComplementListener complementListener;
    DataManager dataManager ;
    GoodsPinInfo goodsPinInfo=new GoodsPinInfo();
    GoodsMainInfo goodsMainInfo=new GoodsMainInfo();
    public MyGoodsinfo(GoodsInfoInterface_pin goodsInfoInterface_pin,DataManager dataManager)
    {
        Log.d("MyGoodsinfo","goodsInfoInterface_pin");
        this.goodsInfoInterface_pin=goodsInfoInterface_pin;
        this.dataManager=dataManager;
    }
    public MyGoodsinfo(GoodsInfoInterface goodsInfoInterface)
    {
        this.goodsInfoInterface=goodsInfoInterface;
    }

    public void getServiceGoodsInfo(int goodsId)
    {
        dataManager.getGoodsInfoByGoodsId(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                Log.d("onNext","homeWares");
                Log.d("onNext","imgurl"+homeWares.getItems().get(0).getItemList().get(0).getGoodsImg());
                goodsInfoInterface_pin.getgoodsinfo_pin(homeWares);
            }
            @Override
            public void onError(Throwable e) {
                Log.d("onNext","homeWares异常"+e);
            }
            @Override
            public void onComplete() {
                Log.d("onNext","homeWares onComplete");
            }
        }, goodsId,false);
    }

    public void setGoodsInfoInterface_pin()
    {
        Log.d("MyGoodsinfo","调用setGoodsInfoInterface_pin");
    }

}
