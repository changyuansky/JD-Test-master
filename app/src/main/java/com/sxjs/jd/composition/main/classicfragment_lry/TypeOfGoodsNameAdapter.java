package com.sxjs.jd.composition.main.classicfragment_lry;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.jd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/24 0024.
 */

public class TypeOfGoodsNameAdapter extends BaseAdapter{
     Activity activity;
     LayoutInflater mInflater;//用来找xml布局文件
     int curPositon;
     List<ClassFication.ItemsBean.ItemListBean> itemListBeanList=new ArrayList<>();
    public TypeOfGoodsNameAdapter(Activity activity, List<ClassFication.ItemsBean.ItemListBean> itemListBeanList){
        this.activity=activity;
        this.itemListBeanList=itemListBeanList;
        mInflater = LayoutInflater.from(activity);
    }

    public int getCurPositon() {
        return curPositon;
    }

    public void setCurPositon(int curPositon) {
        this.curPositon = curPositon;
    }

    //使用 ViewHolder 的好处是缓存了显示数据的视图（View)加快了UI的响应速度。
    class ViewHolder {
        TextView textView;
    }
    @Override
    public int getCount() {
        return itemListBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemListBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        // 如果缓存view为空，则需要创建View
        if (view == null) {
            viewHolder = new ViewHolder();
            //根据自定义的Item布局加载布局
            view = mInflater.inflate(R.layout.depth1_item,null);
            viewHolder.textView = (TextView) view.findViewById(R.id.depth1_tv);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            view.setTag(viewHolder);
        }else{
            //如果view不为空，就会直接用view的getTag()，来获得一个ViewHolder。
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.textView.setText(itemListBeanList.get(i).getCatName());
        if (i == curPositon) {
            view.setBackgroundColor(Color.TRANSPARENT);
            viewHolder.textView.setTextColor(Color.RED);

        }else{
            viewHolder.textView.setTextColor(Color.BLACK);
            view.setBackgroundColor(Color.WHITE);
        }
        return view;
    }

}

