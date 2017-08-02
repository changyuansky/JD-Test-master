package com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */

public class MyAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context context;
    private boolean IsSingle = true;
    private List<HomeWares.ItemsBean.ItemListBean> list;
    
    private String TAG = "adapter";

    public MyAdapter(Context context, List<HomeWares.ItemsBean.ItemListBean> list) {
        this.context = context;
        this.list = list;
    }

    public MyAdapter(Context context, boolean isSingle, List<HomeWares.ItemsBean.ItemListBean> list) {
        this.context = context;
        IsSingle = isSingle;
        this.list = list;

        Log.d(TAG, "MyAdapter: "+list.toString());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (IsSingle == true){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_recyclerview_item_single, parent, false);
            view.setOnClickListener(this);
            RecyclerView.ViewHolder viewHolder = new ItemViewHolderSingle(view);
            return viewHolder;
        }

        if (IsSingle == false){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_recyclerview_item_double, parent, false);
            view.setOnClickListener(this);
            RecyclerView.ViewHolder viewHolder = new ItemViewHolderDouble(view);
            return viewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        HomeWares.ItemsBean.ItemListBean bean = list.get(position);

        if (IsSingle == true){
            final ItemViewHolderSingle itemViewHolder = (ItemViewHolderSingle) holder;

            itemViewHolder.goodsName.setText(bean.getGoodsName());
            itemViewHolder.market_price.setText(bean.getMarketPrice()+"");


            Glide.with(context)
                    .load("http://"+bean.getGoodsImg())
                    .into(itemViewHolder.goodsThumb);

            Log.d(TAG, "onBindViewHolder: 加载图片"+bean.getGoodsThumb());
            
            if (bean.getPromotePrice().equals("0")){
                itemViewHolder.shopPrice.setText(bean.getShopPrice()+"");
                itemViewHolder.ispromote.setText("");
            }else{
                itemViewHolder.shopPrice.setText(bean.getPromotePrice()+"");
                itemViewHolder.ispromote.setText("减价");
            }
            if (bean.isHot ==0){
                itemViewHolder.isHot.setText("");
            }else {
                itemViewHolder.isHot.setText("热销");
            }

        }
        if (IsSingle == false){
            final ItemViewHolderDouble itemViewHolder = (ItemViewHolderDouble) holder;

            itemViewHolder.goodsName.setText(bean.getGoodsName());
            itemViewHolder.market_price.setText(bean.getMarketPrice()+"");


            Glide.with(context)
                    .load("http://"+bean.getGoodsImg())
                    .into(itemViewHolder.goodsThumb);

            Log.d(TAG, "onBindViewHolder: 加载图片"+bean.getGoodsThumb());

            if (bean.getPromotePrice().equals("0")){
                itemViewHolder.shopPrice.setText(bean.getShopPrice()+"");
                itemViewHolder.ispromote.setText("");
            }else{
                itemViewHolder.shopPrice.setText(bean.getPromotePrice()+"");
                itemViewHolder.ispromote.setText("减价");
            }
            if (bean.isHot ==0){
                itemViewHolder.isHot.setText("");
            }else {
                itemViewHolder.isHot.setText("热销");
            }

        }

    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"被点击了",Toast.LENGTH_SHORT).show();
    }


    public static class ItemViewHolderSingle extends RecyclerView.ViewHolder {
        //查找控件
        ImageView goodsThumb;
        TextView goodsName,shopPrice,ispromote,isHot,market_price;
        public ItemViewHolderSingle(View itemView) {
            super(itemView);

            AutoUtils.autoSize(itemView);

            goodsThumb =  itemView.findViewById(R.id.goodsThumb);
            goodsName =  itemView.findViewById(R.id.goodsName);
            shopPrice =  itemView.findViewById(R.id.shopPrice);
            isHot =  itemView.findViewById(R.id.isHot);
            ispromote =  itemView.findViewById(R.id.ispromote);
            market_price = itemView.findViewById(R.id.market_price);
        }
    }

    public static class ItemViewHolderDouble extends RecyclerView.ViewHolder {
        //查找控件
        ImageView goodsThumb;
        TextView goodsName,shopPrice,ispromote,isHot,market_price;

        public ItemViewHolderDouble(View itemView) {
            super(itemView);

            AutoUtils.autoSize(itemView);

            goodsThumb =  itemView.findViewById(R.id.goodsThumb);
            goodsName =  itemView.findViewById(R.id.goodsName);
            shopPrice =  itemView.findViewById(R.id.shopPrice);
            isHot =  itemView.findViewById(R.id.isHot);
            ispromote =  itemView.findViewById(R.id.ispromote);
            market_price = itemView.findViewById(R.id.market_price);
        }
    }

    public List<HomeWares.ItemsBean.ItemListBean> getList() {
        return list;
    }

    public void setList(List<HomeWares.ItemsBean.ItemListBean> list) {
        this.list = list;
    }
}
