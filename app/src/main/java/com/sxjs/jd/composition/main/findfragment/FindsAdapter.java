package com.sxjs.jd.composition.main.findfragment;

import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.base.baseadapter.BaseViewHolder;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.R;


/**
 * Created by admin on 2017/3/22.
 */

public class FindsAdapter extends BaseQuickAdapter<HomeWares.ItemsBean.ItemListBean,BaseViewHolder> {

    public FindsAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, final HomeWares.ItemsBean.ItemListBean bean ,int position) {
        //helper.setText(R.id.title_text,bean.getGoods_id());
        helper.setText(R.id.content_text,bean.getGoodsBrief());
         helper.setText(R.id.author_name , bean.getGoodsName());
        helper.setText(R.id.time_text , bean.getAddTime()+"");
        helper.setText(R.id.page_view_count , ""+bean.getGoodsNumber());
        SimpleDraweeView simpleDraweeView = helper.getView(R.id.content_img);
        SimpleDraweeView authorImg = helper.getView(R.id.author_img);
        simpleDraweeView.setImageURI("http://"+bean.getGoodsImg());
        authorImg.setImageURI("http://"+bean.getGoodsImg());
        helper.addOnClickListener(R.id.find_item_layout);

        setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext, "第"+position+"页 ", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
