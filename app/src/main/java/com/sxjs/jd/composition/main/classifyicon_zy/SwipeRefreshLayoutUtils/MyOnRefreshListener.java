package com.sxjs.jd.composition.main.classifyicon_zy.SwipeRefreshLayoutUtils;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Toast;

import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils.MyAdapter;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Administrator on 2017/7/25.
 */

public class MyOnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;

    public MyOnRefreshListener(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    @Override
    public void onRefresh() {

        GlobalAppComponent.getAppComponent().getDataManager().getCatGoodsInfoByCatIdAndPageindex(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                MyAdapter mAdapter = new MyAdapter(swipeRefreshLayout.getContext(),homeWares.getItems().get(0).getItemList());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, 14, 1, false);


        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(swipeRefreshLayout.getContext(),"刷新成功",Toast.LENGTH_SHORT).show();

    }
}
