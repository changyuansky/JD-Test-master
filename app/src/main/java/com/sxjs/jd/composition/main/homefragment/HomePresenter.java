package com.sxjs.jd.composition.main.homefragment;

import android.util.Log;
import com.sxjs.common.CommonConfig;
import com.sxjs.common.base.rxjava.ErrorDisposableObserver;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.composition.BasePresenter;
import com.sxjs.jd.composition.main.MainActivity;


/**
 * @author admin
 */

public class HomePresenter extends BasePresenter {
    private DataManager mDataManager;

    private MainHomeFragment mHomeView;

    private MainActivity mMainView;

    public HomePresenter(DataManager mDataManager, MainHomeFragment view, MainActivity mainActivity) {
        this.mDataManager = mDataManager;
        this.mHomeView = view;
        mMainView=mainActivity;
    }


    boolean logswitch=false;

    //获取特价商品和轮播图
    public void getHomeBannerImgAndBargainGoods(boolean update){
        mMainView.showProgressDialogView();
        mDataManager.getHomeBannerImgAndBargainGoods(new ErrorDisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                if (logswitch){
                Log.d("yuan", "HomePresenter---getHomeBannerImgAndBargainGoods: onNext（）方法:"+homeWares.getCode());
                Log.d("yuan", "HomePresenter---getHomeBannerImgAndBargainGoods:onNext（）方法,商品名称是"
                        +homeWares.getItems().get(0).getItemList().get(0).getGoods_name());}
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode()))
                    mHomeView.setHomeBannerImgAndBargainGoods(homeWares);
            }

            //如果需要发生Error时操作UI可以重写onError，统一错误操作可以在ErrorDisposableObserver中统一执行
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mMainView.hiddenProgressDialogView();
                if (logswitch) Log.d("yuan", "HomePresenter---getHomeBannerImgAndBargainGoods错误: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                mMainView.hiddenProgressDialogView();
                if (logswitch) Log.d("yuan", "HomePresenter---getHomeBannerImgAndBargainGoods到了onComplete（）方法");
            }
        },update);
    }


    public void getRecommendedWares(boolean update) {
         mDataManager.getHomeWares(new ErrorDisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                if (logswitch){
                Log.d("yuan", "HomePresenter---getRecommendedWares: onNext（）方法"+homeWares.getItems().get(0).getItemList().size());
                Log.d("yuan", "HomePresenter---getRecommendedWares:onNext（）方法,商品名称是"
                        +homeWares.getItems().get(0).getItemList().get(0).getGoods_name());}
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode()))
                mHomeView.setRecommendedWares(homeWares);
            }

            @Override
            public void onError(Throwable e) {
                mHomeView.setRecommendedWares(null);
                if (logswitch) Log.d("yuan", "HomePresenter---getRecommendedWares错误: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                if (logswitch) Log.d("yuan", "HomePresenter---getRecommendedWares: 到了onComplete（）方法");
            }
        },1,update);
    }



//获得更多首页RecommendedWare数据
    public void getMoreRecommendedWares(int pageindex,boolean update) {
        mDataManager.getMoreHomeWares(new ErrorDisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                if (logswitch){Log.d("yuan", "HomePresenter---getMoreRecommendedWares:返回当前页码是："+homeWares.getPageindex());
                Log.d("yuan", "HomePresenter---getMoreRecommendedWares:onNext（）方法,商品名称是"
                        +homeWares.getItems().get(0).getItemList().get(0).getGoods_name());}
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode())) {
                    mHomeView.setMoreRecommendedWares(homeWares);
                }
                //pageindex该如何增加
            }

            @Override
            public void onError(Throwable e) {
                //pageindex该如何减少
                if (logswitch) Log.d("yuan", "HomePresenter---getMoreRecommendedWares错误: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                if (logswitch) Log.d("yuan", "HomePresenter---getMoreRecommendedWares: 到了onComplete（）方法");
            }
        }, pageindex,update);
        if (logswitch) Log.d("yuan", "pageindex:访问页数是 "+pageindex);
    }
}
