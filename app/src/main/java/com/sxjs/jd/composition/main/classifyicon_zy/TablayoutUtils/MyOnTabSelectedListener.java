package com.sxjs.jd.composition.main.classifyicon_zy.TablayoutUtils;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils.MyAdapter;
import com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils.MyDecoration;
import com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils.MyOnScrollListener;

import java.util.Collections;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

import static java.util.Collections.sort;

/**
 * Created by Administrator on 2017/7/25.
 */

public class MyOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

    private RecyclerView recyclerView;
    private String TAG = "MyOnTabSelectedListener";
    private boolean IsSingle = true;
    private int Columns=1;

    public MyOnTabSelectedListener(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                break;
            case 1:
                SortByPrice();
                break;
            case 2:
                if (IsSingle == true){
                    IsSingle =false;
                    Columns = 2;
                    ChangeLayout(IsSingle,Columns);
                }else {
                    IsSingle = true;
                    Columns  = 1;
                    ChangeLayout(IsSingle,Columns);
                }

                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                break;
            case 1:
                break;
            case 2:
                if (IsSingle == true){
                    IsSingle =false;
                    Columns = 2;
                    ChangeLayout(IsSingle,Columns);
                }else {
                    IsSingle = true;
                    Columns  = 1;
                    ChangeLayout(IsSingle,Columns);
                }
                break;
            default:

        }
    }

    public void ChangeLayout(final boolean isSingle, final int columns){

        GlobalAppComponent.getAppComponent().getDataManager().getCatGoodsInfoByCatIdAndPageindex(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {

                if (homeWares != null){

                    MyAdapter myAdapter = new MyAdapter(recyclerView.getContext(),isSingle,homeWares.getItems().get(0).getItemList());
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(),columns));
                    recyclerView.addItemDecoration(new MyDecoration(recyclerView.getContext()));
                    //添加滚动加载更多
                    recyclerView.addOnScrollListener(new MyOnScrollListener(recyclerView.getContext(),myAdapter));

                }else {
                    Toast.makeText(recyclerView.getContext(),"请检查网络设置",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        }, 14, 1, false);
    }

    public void SortByPrice(){
        GlobalAppComponent.getAppComponent().getDataManager().getCatGoodsInfoByCatIdAndPageindex(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {

                if (homeWares != null){

                    List<HomeWares.ItemsBean.ItemListBean>  list = homeWares.getItems().get(0).getItemList();
                    Collections.sort(list,new BeanComparator());

                    MyAdapter myAdapter = new MyAdapter(recyclerView.getContext(),IsSingle,list);
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(),Columns));
                    recyclerView.addItemDecoration(new MyDecoration(recyclerView.getContext()));
                    //添加滚动加载更多
                    recyclerView.addOnScrollListener(new MyOnScrollListener(recyclerView.getContext(),myAdapter));

                }else {
                    Toast.makeText(recyclerView.getContext(),"请检查网络设置",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        }, 14, 1, false);





    }

}
