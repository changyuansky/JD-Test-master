package com.sxjs.jd.composition.main.goodsinfo_xqs.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.sxjs.jd.R;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */

public class MyBaseAdapter extends RecyclerView.Adapter {
    Context context;
    List<String> strings;
    public MyBaseAdapter(Context context, List<String> strings)
    {
        this.context=context;
        this.strings=strings;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.popuwindow_more_item,null);
             //   context.getLayoutInflater().inflate(R.layout.popuwindow_more_item,null);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder= (MyHolder) holder;
        myHolder.textView.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.popu_item_more);
        }
    }
}
