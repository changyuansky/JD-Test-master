package com.sxjs.jd.composition.main.Order.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;


import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.common.bean.OrdergoodsInfo;
import com.sxjs.jd.R;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class MyorderInfoAdapter extends RecyclerView.Adapter<MyorderInfoAdapter.ViewHolder> {
    Context mContext;
    List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean>  itemlist;
    public MyorderInfoAdapter(Context mContext,  List<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean>  items){
       this.mContext=mContext;
        this.itemlist=items;
        Log.d("aa", "MyorderInfoAdapter: "+items.size());
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item1,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.goods_name=(TextView)view.findViewById(R.id.goodsname);
        viewHolder.goods_number=(TextView)view.findViewById(R.id.goodsnumber);
        viewHolder.goods_price=(TextView)view.findViewById(R.id.goodsprice);
        viewHolder.goods_img=(ImageView)view.findViewById(R.id.image);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d("aa", "onBindViewHolder: 位置："+position);
        String imageUrl="http://"+itemlist.get(position).getGoodsImg();
        Glide.with(mContext).load(imageUrl).priority( Priority.HIGH).into(holder.goods_img);
        holder.goods_name.setText(itemlist.get(position).getGoodsName());
        Log.d("aa",itemlist.get(position).getGoodsName());
        holder.goods_number.setText("数量："+itemlist.get(position).getGoodsNumber()+"");
        Log.d("aa",itemlist.get(position).getGoodsNumber()+"");
        holder.goods_price.setText("￥："+itemlist.get(position).getGoodsPrice()+"");
        Log.d("aa",itemlist.get(position).getGoodsPrice()+"");
        OnItemClick(holder);
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView goods_name;TextView goods_number;
        TextView goods_price;ImageView goods_img;
    Button car;
        public ViewHolder(View itemView) {
            super(itemView);
            car=itemView.findViewById(R.id.add);
        }
    }

    private void OnItemClick(ViewHolder holder){
        holder.car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"加入购物车",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
