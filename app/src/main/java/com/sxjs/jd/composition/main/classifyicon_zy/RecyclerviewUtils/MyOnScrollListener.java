package com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.composition.main.classifyicon_zy.TablayoutUtils.BeanComparator;

import java.util.Collections;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Administrator on 2017/7/25.
 */

public class MyOnScrollListener extends RecyclerView.OnScrollListener {


    private int current_page = 1;
    private int next_page = current_page+1;

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
            loagmore(next_page);

            current_page++;
            next_page++;
        }
    }


    public static boolean isVisBottom(RecyclerView recyclerView){
        GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        //屏幕中最后一个可见子项的position
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        //当前屏幕所看到的子项个数
        int visibleItemCount = layoutManager.getChildCount();
        //当前RecyclerView的所有子项个数
        int totalItemCount = layoutManager.getItemCount();
        //RecyclerView的滑动状态
        int state = recyclerView.getScrollState();
        if(visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 && state == recyclerView.SCROLL_STATE_IDLE){
            return true;
        }else {
            return false;
        }
    }


   public void loagmore(int next_page ){

       int page = next_page;

       GlobalAppComponent.getAppComponent().getDataManager().getCatGoodsInfoByCatIdAndPageindex(new DisposableObserver<HomeWares>() {
           @Override
           public void onNext(HomeWares homeWares) {
               myAdapter.getList().addAll(homeWares.getItems().get(0).getItemList());

               List<HomeWares.ItemsBean.ItemListBean> list = myAdapter.getList();

               Collections.sort(list,new BeanComparator());

               myAdapter.notifyDataSetChanged();
           }

           @Override
           public void onError(Throwable e) {
               Toast.makeText(context, "没有更多了", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onComplete() {

           }
       }, 14, page,false);
   }

}
