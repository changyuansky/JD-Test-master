package com.sxjs.jd.composition.main.classificationfragment;

import android.util.Log;
import android.widget.Toast;

import com.sxjs.common.CommonConfig;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.common.bean.HomeBannerImg;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.composition.BasePresenter;
import com.sxjs.jd.composition.main.homefragment.MainHomeFragment;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by admin on 2017/3/22.
 */

public class ClassificationPresenter extends BasePresenter {
    private DataManager mDataManager;

    private ClassificationContract.View mClassificationView;
    @Inject
    public ClassificationPresenter(DataManager mDataManager, ClassificationContract.View view) {
        this.mDataManager = mDataManager;
        this.mClassificationView = view;

    }


    public void getTypeOfNameData(boolean update,int parentId) {
        //以下两行是原有数据，供参考
//        List<String> typeOfNameData = mDataManager.getTypeOfNameData();
//        mClassificationView.setTypeOfNameData(typeOfNameData);

//parentId需不需要传入，需要传多少？
        mDataManager.getClassFication(new DisposableObserver<ClassFication>() {
            @Override
            public void onNext(ClassFication classFication) {
                if (classFication.getCode().equals(CommonConfig.SUCCESS_CODE)){
                    Log.d("yuan", "进入getTypeOfNameData");
                    //setTypeOfNameData()形参需要根据要求发生相应的改变
                    mClassificationView.setTypeOfNameData(classFication.getItems());
                }else {
                    //对错误进行处理，避免空指针异常
                    Toast.makeText(GlobalAppComponent.getAppComponent().getContext(),
                            "请求错误", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable e) {
                mClassificationView.setTypeOfNameData(null);
                //对错误进行相应处理
            }

            @Override
            public void onComplete() {

            }
        },parentId,update);
    }


    //需要根据 “分类页面” 的点击事件进行调用
    //根据   “catId”   得到相应的商品信息
    public void getClassMoreInfo(int catId) {
        mDataManager.getCatGoodsInfoByCatIdAndPageindex(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares classGoodsInfo) {
//                if (logswitch){
//                    Log.d("yuan", "HomePresenter---getHomeBannerImg: onNext（）方法"+homeBannerImg.getCode());
//                    Log.d("yuan", "HomePresenter---getHomeBannerImg:onNext（）方法,商品名称是"
//                            +homeBannerImg.getItems().get(0).getItemList().get(0).getAdCode());}
                if (classGoodsInfo.getCode().equals(CommonConfig.SUCCESS_CODE)){
                    //数据获取成功之后的数据处理
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },catId,1,false);
    }

  //获取分类二，三级数据
    public void getTypeIconsData() {

    }
}
