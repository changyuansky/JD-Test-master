package com.sxjs.jd.composition.main.classicfragment_lry;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.homefragment.MyHomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/22.
 */

public class TypeOfGoodsNameAdapter3 extends BaseAdapter {
    TypeOfGoodsNameAdapter3 adapter3;

    TextView textView;
    Activity activity;
    List<Fenlei> booklist_depth3;
    private static String TAG="TypeOfGoodsNameAdapter3";
    public TypeOfGoodsNameAdapter3 (Activity activity,List<Fenlei> booklist_depth3 ) {
        this.activity=activity;
        this.booklist_depth3=booklist_depth3;
    }
    List<ClassFication.ItemsBean.ItemListBean> mItemList_all; //从服务器拿到的所有分类信息


    @Override
    public int getCount() {
        Log.d("lry","绑定数据到gridvewi_getCount="+booklist_depth3.size());
        return booklist_depth3.size();

    }

    @Override
    public Object getItem(int i) {
        return booklist_depth3.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d(TAG, "getView: "+View.inflate(activity, R.layout.depth3_gridv_item, null));
        View item = view != null ? view : activity.getLayoutInflater().inflate(R.layout.depth3_gridv_item, null);
        textView= (TextView) item.findViewById(R.id.depth3_tv);
        textView.setText(booklist_depth3.get(i).getCatName());
        Log.d("lry","绑定数据到gridvewi");
        OnClick();
        return item;
    }


    public void OnClick(){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Fenlei> booklist_depth3=new ArrayList<>();
                for (int k=0;k<booklist_depth3.size();k++){
                    int cid=booklist_depth3.get(k).getCatId();
                    Fenlei fenlei=new Fenlei();
                    fenlei.setCatId(cid);
                }
//                ARouter.getInstance().build("/test/activity2").withInt("catId",booklist_depth3.get(i).getCatId()).navigation();
            }
        });
    }

}
