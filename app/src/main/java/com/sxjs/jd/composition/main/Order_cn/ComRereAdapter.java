package com.sxjs.jd.composition.main.Order_cn;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.base.baseadapter.BaseViewHolder;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.jd.R;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public class ComRereAdapter extends BaseQuickAdapter<MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean,BaseViewHolder> {
   String tag="DfkFragment";
    Activity activity;
    public ComRereAdapter(int layoutResId, Activity activity) {

        super(layoutResId);
        this.activity=activity;
        Log.d(tag,"ComRereAdapter(int layoutResId, Activity activity)");
    }
    @Override
    protected void convert(BaseViewHolder helper, MyOrderInfo.ItemsBean.ItemListBean.OrderGoodsBean item, int position) {
        Log.d(tag,"convert");
        ImageView reitemone_i= helper.getView(R.id.frag_recyler_item_reitemone_i);
        TextView  reitemone_t=helper.getView(R.id.frag_recyler_item_reitemone_t);
        Log.d(tag,"url="+item.getGoodsImg());
      //  String ulttemp="http://192.168.1.110/CN/imgs/1.png";
        //http://10.10.140.231:8080/XJD/data/images/201507/thumb_img/110_thumb_G_1437523812526.jpg
        String ulttemp="http://"+item.getGoodsImg();
        //ulttemp用item.getGoods_img()
         Glide.with(activity)
                        .load(ulttemp)
                        .into( reitemone_i);
           reitemone_t.setText(item.getGoodsName());

    }
}
