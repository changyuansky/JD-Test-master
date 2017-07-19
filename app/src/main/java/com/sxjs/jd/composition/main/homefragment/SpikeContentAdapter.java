package com.sxjs.jd.composition.main.homefragment;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.base.baseadapter.BaseViewHolder;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.util.ScreenUtil;
import com.sxjs.common.widget.imageview.ExpandImageView;
import com.sxjs.jd.R;
import com.sxjs.jd.entities.HomeIndex;

import java.util.List;

/**
 * @author：admin on 2017/3/30 18:00.
 */
//秒杀适配器HomeIndex.ItemInfoListBean.ItemContentListBean
public class SpikeContentAdapter extends BaseQuickAdapter<HomeWares.ItemsBean.ItemListBean,BaseViewHolder> {
    public SpikeContentAdapter(int layoutResId, List<HomeWares.ItemsBean.ItemListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeWares.ItemsBean.ItemListBean item, int position) {
        ((ExpandImageView) helper.getView(R.id.spike_ware_img)).setImageURI("http://"+item.getGoodsThumb());
        helper.setText(R.id.spike_ware_now_price,item.getGoodsName());
        helper.setText(R.id.spike_ware_old_price,item.getShopPrice()+"");

    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.homerecycle_spike_content,null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) (0.286 * ScreenUtil.getScreenWidth(mContext)), LinearLayout.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return view;
    }
}
