package com.sxjs.jd.composition.main;

import android.util.Log;

import com.sxjs.common.base.rxjava.ErrorDisposableObserver;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.composition.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
* Created by admin on 2017/03/12
*/

public class MainPresenter extends BasePresenter implements MainContract.Presenter{
    private DataManager mDataManager;

    private MainContract.View mMainView;
    private static final String TAG = "MainPresenter";

    public MainPresenter(DataManager mDataManager, MainContract.View view) {
        this.mDataManager = mDataManager;
        this.mMainView = view;

    }

    @Override
    public void destory() {
        if(disposables != null){
            disposables.clear();
        }
    }

    @Override
    public void saveData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username","xiaoming");
        map.put("password","123456");
        mDataManager.saveSPMapData(map);
    }

    @Override
    public Map<String, String> getData() {
        return mDataManager.getSPMapData();
    }

}