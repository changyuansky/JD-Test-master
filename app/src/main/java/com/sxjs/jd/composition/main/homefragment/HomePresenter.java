package com.sxjs.jd.composition.main.homefragment;

import android.util.Log;
import android.widget.Toast;

import com.sxjs.common.CommonConfig;
import com.sxjs.common.base.rxjava.ErrorDisposableObserver;
import com.sxjs.common.bean.HomeBannerImg;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.composition.BasePresenter;

import io.reactivex.observers.DisposableObserver;

/**
 * @author admin
 */

public class HomePresenter extends BasePresenter {
    private DataManager mDataManager;

    private MainHomeFragment mHomeView;

    public HomePresenter(DataManager mDataManager, MainHomeFragment view) {
        this.mDataManager = mDataManager;
        this.mHomeView = view;

    }


    boolean logswitch=true;
    public void getHomeBannerImg(boolean update){
        mDataManager.getHomeBannerImg(new DisposableObserver<HomeBannerImg>() {
            @Override
            public void onNext(HomeBannerImg homeBannerImg) {
                if (logswitch){
                Log.d("yuan", "HomePresenter---getHomeBannerImg: onNext（）方法"+homeBannerImg.getCode());
                Log.d("yuan", "HomePresenter---getHomeBannerImg:onNext（）方法,商品名称是"
                        +homeBannerImg.getItems().get(0).getItemList().get(0).getAdCode());}

                if (homeBannerImg.getCode().equals(CommonConfig.SUCCESS_CODE))
                mHomeView.setHomeBannerImgData(homeBannerImg);
            }

            @Override
            public void onError(Throwable e) {
                mHomeView.setHomeBannerImgData(null);
            }

            @Override
            public void onComplete() {

            }
        },update);
    }

//获取特价商品
    public void getBargainGoods(boolean update){
        mDataManager.getBargainGoods(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                if (logswitch){
                Log.d("yuan", "HomePresenter---getBargainGoods: onNext（）方法"+homeWares.getItems().get(0).getItemType());
                Log.d("yuan", "HomePresenter---getBargainGoods:onNext（）方法,商品名称是"
                        +homeWares.getItems().get(0).getItemList().get(0).getGoodsName());}
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode()))
                    mHomeView.setBargainGoods(homeWares);
            }

            @Override
            public void onError(Throwable e) {
                if (logswitch) Log.d("yuan", "HomePresenter---getBargainGoods错误: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                if (logswitch) Log.d("yuan", "HomePresenter---getBargainGoods: 到了onComplete（）方法");
            }
        },update);
    }


    public void getRecommendedWares(boolean update) {
         mDataManager.getHomeWares(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                if (logswitch){
                Log.d("yuan", "HomePresenter---getRecommendedWares: onNext（）方法"+homeWares.getItems().get(0).getItemType());
                Log.d("yuan", "HomePresenter---getRecommendedWares:onNext（）方法,商品名称是"
                        +homeWares.getItems().get(0).getItemList().get(0).getGoodsName());}
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode()))
                mHomeView.setRecommendedWares(homeWares);
            }

            @Override
            public void onError(Throwable e) {
                if (logswitch) Log.d("yuan", "HomePresenter---getRecommendedWares错误: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                if (logswitch) Log.d("yuan", "HomePresenter---getRecommendedWares: 到了onComplete（）方法");
            }
        },1,update);
    }


    int pageindex = 1;
//获得更多首页RecommendedWare数据
    public void getMoreRecommendedWares(boolean update) {
        int pageindex_temp=pageindex+1;
        //pageindex该如何增加
        mDataManager.getMoreHomeWares(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                String code = homeWares.getCode();
                if (logswitch){Log.d("yuan", "HomePresenter---getMoreRecommendedWares: onNext（）方法"+homeWares.getCode());
                Log.d("yuan", "HomePresenter---getMoreRecommendedWares:onNext（）方法,商品名称是"
                        +homeWares.getItems().get(0).getItemList().get(0).getGoodsName());}
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode())) {
                    mHomeView.setMoreRecommendedWares(homeWares);
                    pageindex=homeWares.getPageindex();
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
        }, pageindex_temp,false);
        //if (logswitch) Log.d("yuan", "pageindex:访问页数是 "+pageindex);
    }
}
