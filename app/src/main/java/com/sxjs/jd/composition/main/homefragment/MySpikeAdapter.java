package com.sxjs.jd.composition.main.homefragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.widget.imageview.ExpandImageView;
import com.sxjs.jd.R;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */

public class MySpikeAdapter extends RecyclerView.Adapter<MySpikeAdapter.SpikeHolder> implements View.OnClickListener{

    Context context;
    List<HomeWares.ItemsBean.ItemListBean> itemListBeanList;
    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public MySpikeAdapter(Context context, List<HomeWares.ItemsBean.ItemListBean> itemListBeanList) {
        this.itemListBeanList = itemListBeanList;
        this.context = context;
    }

    @Override
    public SpikeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homerecycle_spike_content, parent, false);
        view.setOnClickListener(this);
        return new SpikeHolder(view);
    }

    @Override
    public void onBindViewHolder(SpikeHolder holder, int position) {
                Glide.with(context)
                        .load("http://" + itemListBeanList.get(position).getGoodsImg())
                        .into(holder.spike_ware_img);
//                Log.d("yuan", "Spike名字=" + itemListBeanList.get(position).getGoodsName()+";位置="+position);
        holder.spike_ware_now_price.setText(itemListBeanList.get(position).getShopPrice() + "");
        holder.spike_ware_old_price.setText(itemListBeanList.get(position).getGoodsName());
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return itemListBeanList.size();
    }

    public class SpikeHolder extends RecyclerView.ViewHolder{
        ImageView spike_ware_img;
        TextView spike_ware_now_price;
        TextView spike_ware_old_price;
        public SpikeHolder(View itemView) {
            super(itemView);
            spike_ware_img = itemView.findViewById(R.id.spike_ware_img);
            spike_ware_now_price = itemView.findViewById(R.id.spike_ware_now_price);
            spike_ware_old_price = itemView.findViewById(R.id.spike_ware_old_price);
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }
}
