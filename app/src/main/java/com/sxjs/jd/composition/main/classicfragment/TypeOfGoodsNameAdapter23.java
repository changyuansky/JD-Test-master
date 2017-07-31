package com.sxjs.jd.composition.main.classicfragment;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.base.baseadapter.BaseViewHolder;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.jd.R;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/3/22.
 */

public class TypeOfGoodsNameAdapter23 extends BaseAdapter {
    Activity mActivity;
    List<HetiFenlei> mList;
    GridView gridView;
    TextView textView;

    public TypeOfGoodsNameAdapter23(Activity activity, List<HetiFenlei> list) {
        this.mActivity = activity;
        this.mList = list;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item = view != null ? view : View.inflate(mActivity,R.layout.depth23_item, null);
        textView = (TextView) item.findViewById(R.id.depth23_tv);
        gridView = (GridView) item.findViewById(R.id.depth3_gridview);
        textView.setText(mList.get(i).getFenlei().getCatName());
        gridView.setNumColumns(3);
        Log.d("lry", "三级分类的数量是=" + mList.get(i).getFenleiList().size());
        gridView.setAdapter(new TypeOfGoodsNameAdapter3(mActivity, mList.get(i).getFenleiList()));
        //OnClick(view);
        return item;
    }

//    public void OnClick(View view) {
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mActivity, "" + view, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(mActivity, "" + i, Toast.LENGTH_SHORT).show();
//            }
//        });
//        switch (view.getId()== R.id.depth23_tv) {
//                ARouter.getInstance().build("/test/activity2").navigation();
//        }
//    }
}
