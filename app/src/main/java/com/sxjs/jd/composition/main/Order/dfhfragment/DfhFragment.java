package com.sxjs.jd.composition.main.Order.dfhfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sxjs.common.base.BaseFragment;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.Order.myviews.AutoListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Administrator on 2017/7/16 0016.
 */

public class DfhFragment extends BaseFragment implements AutoListView.OnRefreshListener ,AutoListView.OnLoadListener  {
    String tag="DfhFragment";
    @BindView(R.id.Dfh_Al1)
    AutoListView autoListView;
    @BindView(R.id.Dfh_view_emp)
    LinearLayout linearLayout;
    DfhAdapter dfhAdapter;
    int Pageindex=1;
    List<MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean> OrderInfoslist;
    List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> OrderGoodslist;
    public static DfhFragment newInstance() {
        return new DfhFragment();
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(tag,"onCreateView");
        View view=inflater.inflate(R.layout.dfhfragment,null);
        unbinder = ButterKnife.bind(this, view);
        OrderInfoslist=new ArrayList<>();
        OrderGoodslist=new ArrayList<>();
        initData();
        initView();
        return view;

    }
    public void initView() {
        Log.d(tag,"initView");
        autoListView.setEmptyView(linearLayout);
        autoListView.setOnLoadListener(this);
        autoListView.setOnRefreshListener(this);
    }

    public void initData() {
        Log.d(tag,"initData");
        getdata(1);

    }
    public void getdata(int pageindex){
        Log.d(tag,"getdata");
        getAppComponent().getDataManager().getShipNoOrderInfoByUserIdAndPageindex(new DisposableObserver<MyOrderInfo>() {
            @Override
            public void onNext(MyOrderInfo myOrderInfo) {
                setdata(myOrderInfo);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },7,pageindex,true);
    }

    public void setdata(MyOrderInfo myOrderInfo) {
        Log.d(tag,"setdata");
        if(myOrderInfo.getCode().equals("200")){
            int p=myOrderInfo.getPageindex();
            String i=myOrderInfo.getIsOver();
            List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> orderGoodslist =myOrderInfo.getItems().get(0).getItemList().get(0).getOrderGoods();
            List<MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean> orderInfoslist =myOrderInfo.getItems().get(0).getItemList().get(0).getOrderInfos();
            Log.d(tag,"setdata:"+orderGoodslist.size());
            Log.d(tag,"setdata:"+orderInfoslist.size());
            autoListView.setResultSize(orderInfoslist.size(),i);
            if(p==1){
                Log.d(tag,"setdata:"+"p==1");
                OrderInfoslist=orderInfoslist;
                OrderGoodslist=orderGoodslist;
            }
            if (p>1){
                Log.d(tag,"setdata:"+"p>1");
                OrderInfoslist.addAll(orderInfoslist);
                OrderGoodslist.addAll(orderGoodslist);
                Pageindex=p;

            }
        }
        else{
            Toast.makeText(getActivity(),"获取失败", Toast.LENGTH_SHORT).show();
        }
        if(OrderInfoslist!=null&&OrderGoodslist!=null){
            if(dfhAdapter ==null){
                Log.d(tag,"setdata:"+"new DfkAdapter");
                dfhAdapter=new DfhAdapter(getActivity(),OrderInfoslist,OrderGoodslist);
                autoListView.setAdapter(dfhAdapter);
            }
            else{
                Log.d(tag,"setdata:"+"dfkAdapter.putdata");
                dfhAdapter.putdata(OrderInfoslist,OrderGoodslist);
                dfhAdapter.notifyDataSetChanged();
            }
        }

        autoListView.onRefreshComplete();
        autoListView.onLoadComplete();
    }


    @Override
    public void onRefresh() {
        Log.d(tag,"onRefresh");
        getdata(1);
    }

    @Override
    public void onLoad() {
        Log.d(tag,"onLoad");
        int p=Pageindex+1;
        getdata(p);
    }
}
