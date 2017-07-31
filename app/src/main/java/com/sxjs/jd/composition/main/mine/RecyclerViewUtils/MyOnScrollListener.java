package com.sxjs.jd.composition.main.mine.RecyclerViewUtils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.HomeWares;

import java.util.Collections;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

public class MyOnScrollListener extends RecyclerView.OnScrollListener {

    private  String TAG = "MyOnScrollListener";

    private int next_page = 1;

    private Context context;
    private MyAdapter myAdapter;

    public MyOnScrollListener(Context context, MyAdapter myAdapter) {
        this.context = context;
        this.myAdapter = myAdapter;
    }

    @Override
    public void onScrolled(final RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (isVisBottom(recyclerView)){
            //加载更多
            next_page++;
            if (next_page<=4){
                loagmore(next_page);
            }
            Log.d(TAG, "onScrolled: "+next_page);
        }
    }


    public static boolean isVisBottom(RecyclerView recyclerView){
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }


    public void loagmore(int page ){



        GlobalAppComponent.getAppComponent().getDataManager().getHomeWares(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                myAdapter.getList().addAll(homeWares.getItems().get(0).getItemList());
                myAdapter.notifyDataSetChanged();
                if ( homeWares.getPageindex() == 4 ){
                    Toast.makeText(context,"没有更多数据了",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, page,false);
        Log.d(TAG, "loagmore: "+page);
    }

}