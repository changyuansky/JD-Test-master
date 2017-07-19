package com.sxjs.jd.composition.main.findfragment;

import com.sxjs.common.base.rxjava.ErrorDisposableObserver;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.composition.BasePresenter;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by admin on 2017/3/22.
 */

public class FindPresenter extends BasePresenter {
    private DataManager mDataManager;

    private  FindFragment mFindView;

    public FindPresenter(DataManager mDataManager, FindFragment view) {
        this.mDataManager = mDataManager;
        this.mFindView = view;

    }



    public void getFindData() {
        //根据自己要求
//        addDisposabe(mDataManager.getData(new ErrorDisposableObserver<FindsBean>() {
//            @Override
//            public void onNext(FindsBean findsBean) {
//                mFindView.setFindData(findsBean);
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        },FindsBean.class, "find.txt"));
    }


    public void getMoreFindData() {
//        addDisposabe(mDataManager.getData(new DisposableObserver<FindsBean>() {
//            @Override
//            public void onNext(FindsBean findsBean) {
//                mFindView.setMoreData(findsBean);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        },FindsBean.class, "find.txt"));
    }
}
