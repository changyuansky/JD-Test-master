package com.sxjs.jd.composition.main.mine.RecyclerViewUtils;

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

import java.util.List;

/**
 * Created by 侯少伟 on 2017/7/28.
 */

public class MyAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private Context context;
    private List<HomeWares.ItemsBean.ItemListBean> list;

    private String TAG = "adapter";

    public MyAdapter(Context context, List<HomeWares.ItemsBean.ItemListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_recyclerview_head, parent, false);
            RecyclerView.ViewHolder viewHolder = new HeadViewHolder(view);
            return viewHolder;

        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_recyclerview_item, parent, false);
            view.setOnClickListener(this);
            RecyclerView.ViewHolder viewHolder = new ItemViewHolder(view);
            return viewHolder;
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (position > 0 ){
            HomeWares.ItemsBean.ItemListBean bean = list.get(position-1);

            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

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
        return  list.size()+1;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"被点击了",Toast.LENGTH_SHORT).show();
    }


    public static class HeadViewHolder extends RecyclerView.ViewHolder {
        public HeadViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        //查找控件
        ImageView goodsThumb;
        TextView goodsName,shopPrice,ispromote,isHot,market_price;

        public ItemViewHolder(View itemView) {
            super(itemView);

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
