package com.sxjs.jd.composition.main.goodsinfo_xqs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.sxjs.jd.R;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class GridViewAdapter extends BaseAdapter {
    List<String> strings;
    Context context;
    int [] imgs=new int[]{R.mipmap.weixin, R.mipmap.pengyouquan,R.mipmap.qq,R.mipmap.kongjian};
    public GridViewAdapter( List<String> strings,Context context)
    {
        this.strings=strings;
        this.context=context;

    }
    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int i) {
        return strings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.popuwindow_share_gridview_item,null);
        ImageView imageView=view.findViewById(R.id.main_more_gridview_image);
        imageView.setBackgroundResource(imgs[i]);
        TextView textView=view.findViewById(R.id.main_more_gridview_text);
        textView.setText(strings.get(i));
        return view;
    }
}
