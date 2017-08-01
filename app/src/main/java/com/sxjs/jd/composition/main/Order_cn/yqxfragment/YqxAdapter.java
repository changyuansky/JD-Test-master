package com.sxjs.jd.composition.main.Order_cn.yqxfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

import com.google.gson.Gson;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.Order_cn.ComRereAdapter;
import com.sxjs.jd.composition.main.Order_cn.Detail;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Administrator on 2017/7/21 0021.
 */

public class YqxAdapter extends BaseAdapter {

    String tag="YqxFragment";
    public Activity activity;
    public List<MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean> Infoslist=new ArrayList<>();
    public List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> Goodslist=new ArrayList<>();
    public ComRereAdapter comRereAdapter;
    public LinearLayout linearLayout;
    public Button button;


    public YqxAdapter(Activity activity, List<MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean> OrderInfoslist, List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> OrderGoodslist){
        Log.d(tag,"YqxAdapter(Activity activity,");
        this.activity=activity;
        Infoslist=OrderInfoslist;
        Goodslist=OrderGoodslist;
        Log.d(tag,"setdata:"+OrderGoodslist.size());
        Log.d(tag,"setdata:"+OrderInfoslist.size());

    }
    public void putdata( List<MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean> OrderInfoslist, List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> OrderGoodslist){
        Log.d(tag,"putdata");
        Infoslist=OrderInfoslist;
        Goodslist=OrderGoodslist;

    }
    public int getCount() {
        Log.d(tag,"getCount()"+ Infoslist.size());
        return Infoslist.size();
    }
    @Override
    public Object getItem(int position) {
        Log.d(tag," getItem");
        return Infoslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.d(tag,"getItemId");
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Log.d(tag," getView");
        View view=activity.getLayoutInflater().inflate(R.layout.com_recyler_item,null);
        ImageView delete=(ImageView)view.findViewById(R.id.com_recyler_item_delete);
        TextView hint=(TextView)view.findViewById(R.id.com_recyler_item_hint);
        button=(Button)view.findViewById(R.id.com_recyler_item_bzcgm);
        RecyclerView goodsshow=(RecyclerView)view.findViewById(R.id.com_recyler_item_recyclerView);
        TextView shopname=(TextView) view.findViewById(R.id.com_recyler_item_name);
        TextView goodsnum=(TextView) view.findViewById(R.id.com_recyler_item_num);
        TextView goodsprice=(TextView)view.findViewById(R.id.com_recyler_item_price);

        button.setVisibility(View.VISIBLE);
        button.setText("再次购买");
        hint.setText("已取消");
        Log.d(tag," getView:"+"OrderInfoslist.get(position)");
        final MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean orderInfosBean=Infoslist.get(position);

       delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      Infoslist.remove(orderInfosBean);
                      //同步数据库
                      GlobalAppComponent.getAppComponent().getDataManager().getDeleteOrderInfoByOrderId(new DisposableObserver<MyOrderInfo>() {
                          @Override
                          public void onNext(MyOrderInfo myOrderInfo) {
                              //返回删除订单的信息
                          }

                          @Override
                          public void onError(Throwable e) {

                          }

                          @Override
                          public void onComplete() {

                          }
                      },orderInfosBean.getOrderId(),false);
                      notifyDataSetChanged();
                  }
              };
                AlertDialog.Builder builder=new AlertDialog.Builder(activity);
                builder.setTitle("确定要删除吗");
                builder.setPositiveButton("确定",listener);
                builder.setNegativeButton("取消",null);
                builder.show();
            }
        });


        shopname.setText(orderInfosBean.getSupplierName());
        goodsprice.setText(orderInfosBean.getMoneyPaid()+" ");



        Log.d(tag," getView:"+"ordergoods");
        List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> PartOrderGoodslist=new ArrayList<>();
        PartOrderGoodslist= ordergoods(orderInfosBean.getOrderId());

        if(PartOrderGoodslist==null||PartOrderGoodslist.size()<1){
            goodsnum.setText("0");
        }
        else{
            int Goodsnum=0;
            for(int j=0;j<PartOrderGoodslist.size();j++){
                Goodsnum=Goodsnum+PartOrderGoodslist.get(j).getGoodsNumber();
            }

            goodsnum.setText(Goodsnum+"");

            Log.d(tag," getView:"+"ordergoods"+Goodsnum);
        }

        GridLayoutManager gridLayoutManager=new GridLayoutManager(activity,1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        goodsshow.setLayoutManager(gridLayoutManager);
        comRereAdapter=new ComRereAdapter(R.layout.frag_recyler_item_reitemone,activity);
        Log.d(tag," getView:"+"goodsshow.setAdapter");
        goodsshow.setAdapter(comRereAdapter);
        comRereAdapter.addData(PartOrderGoodslist);

        setOnItemClickListener();
        return view;
    }



    public void setOnItemClickListener(){
        comRereAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(activity,"进入商品详情", Toast.LENGTH_SHORT).show();
                int orderid= Goodslist.get(position).getOrderId();
                Detail detail=new Detail();
                detail.setOrderid(orderid);
                detail.setGoodslist(ordergoods(orderid));
                detail.setInfos(orderInfos(orderid));
                Gson gson=new Gson();
                ARouter.getInstance().build("/test/1").withString("details",gson.toJson(detail))
                        .navigation();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"再次购买", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public  List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> ordergoods(int orderid){
        Log.d(tag,"ordergoods");
        Log.d(tag," getView:"+"ordergoods"+orderid);
        List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean> partOrderGoodslist=new ArrayList<>();
        for(int i=0;i<Goodslist.size();i++){
            Log.d(tag," getView:"+"ordergoods"+i);
            if(Goodslist.get(i).getOrderId()==orderid){

                partOrderGoodslist.add(Goodslist.get(i));
                Log.d(tag,"1");
            }
            Log.d(tag,"2");
        }

        Log.d(tag," getView:"+partOrderGoodslist.size());
        return partOrderGoodslist;

    }
    public  MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean orderInfos(int orderid){
        MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean Infos=new  MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean();
        for(int i=0;i<Infoslist.size();i++){
            Log.d(tag," getView:"+"ordergoods"+i);
            if(Infoslist.get(i).getOrderId()==orderid){
                Infos=Infoslist.get(i);
            }
        }
        return  Infos;
    }


}

