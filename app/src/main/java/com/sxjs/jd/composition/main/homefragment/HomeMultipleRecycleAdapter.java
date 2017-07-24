package com.sxjs.jd.composition.main.homefragment;

import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sxjs.common.base.baseadapter.BaseMultiItemQuickAdapter;
import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.base.baseadapter.BaseViewHolder;
import com.sxjs.common.bean.HomeBannerImg;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.widget.autoscrollviewpager.BGABanner;
import com.sxjs.common.widget.imageview.ExpandImageView;
import com.sxjs.jd.R;
import com.sxjs.common.data.Constant;


/**
 * @author admin 数据绑定未进行详细的数据验证，再实际使用中不可取
 */
public class HomeMultipleRecycleAdapter extends BaseMultiItemQuickAdapter<HomeWares.ItemsBean, BaseViewHolder> implements BaseQuickAdapter.SpanSizeLookup, BaseQuickAdapter.OnItemChildClickListener {

    private CountDownTimer timer;
    private int maxHasLoadPosition;

    /**
     * 当前position监听
     */
    private PositionChangedListener listener;

    public void setListener(PositionChangedListener listener) {
        this.listener = listener;
    }

    public void resetMaxHasLoadPosition() {
        maxHasLoadPosition = 0;
    }

    public HomeMultipleRecycleAdapter() {
        setSpanSizeLookup(this);
        Log.d("yuan", "进入HomeMultipleRecycleAdapter:适配器");
        addItemType(Constant.TYPE_TOP_BANNER, R.layout.homerecycle_item_top_banner);
        //特价商品。不分页显示
        addItemType(Constant.TYPE_JD_SPIKE_CONTENT, R.layout.homerecycle_item_spike_content);
       //推荐商品 分页显示
        addItemType(Constant.TYPE_RECOMMENDED_WARE, R.layout.homerecycle_item_type_recommented_ware);
    }

    /**
     * 数据绑定未进行详细的数据验证，在实际使用中不可取
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     * @param position
     */
    @Override
    protected void convert(BaseViewHolder helper, HomeWares.ItemsBean item, int position) {
        if (listener != null) {
            listener.currentPosition(position);
        }
        if (maxHasLoadPosition < position) {
            maxHasLoadPosition = position;
        }
            //这里的itemType怎么办
//        if () {
            //bindIconListData(helper, item, position);
//            Log.d("yuan", "进入HomeMultipleRecycleAdapter:绑定10个图");
//        }
        //特价商品
        if ("topBanner".equals(item.itemType)){
            bindTopBannerData(helper, item, position);
        }else if ("goods".equals(item.itemType)) {
            bindJDSpikeContentData(helper, item, position);
            Log.d("yuan", "进入HomeMultipleRecycleAdapter:绑定特价商品");
        }else if ("recommended_ware".equals(item.itemType)) {
            Log.d("yuan", "进入HomeMultipleRecycleAdapter:绑定推荐商品");
            bindRecommendedWareData(helper, item, position);
        }
    }



    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return mData.get(position).getSpanSize();
    }


    /**
     * 绑定banner数据
     *
     * @param helper
     * @param item
     * @param position
     */
    private void bindTopBannerData(BaseViewHolder helper, final HomeWares.ItemsBean item, int position) {
        BGABanner banner = helper.getView(R.id.banner);
        banner.setDelegate(new BGABanner.Delegate<View, HomeWares.ItemsBean.ItemListBean>() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, HomeWares.ItemsBean.ItemListBean model, int position) {
                Toast.makeText(itemView.getContext(), "" +model.getAd_name(), Toast.LENGTH_SHORT).show();
            }
        });
        banner.setAdapter(new BGABanner.Adapter<View, HomeWares.ItemsBean.ItemListBean>() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, HomeWares.ItemsBean.ItemListBean model, int position) {
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv_item_fresco_content);
                simpleDraweeView.setImageURI("http://"+Uri.parse(model.getAd_code()));
            }
        });

        banner.setData(R.layout.homerecycle_top_banner_content, item.getItemList(), null);
    }

    private void bindJDSpikeContentData(BaseViewHolder helper, HomeWares.ItemsBean item, int position) {
        if (item.getItemList() == null || item.getItemList().size() <= 0) return;
        RecyclerView recyclerView = helper.getView(R.id.spike_content_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        SpikeContentAdapter adapter = new SpikeContentAdapter(R.layout.homerecycle_item_spike_content, item.getItemList());
        recyclerView.setAdapter(adapter);
    }

    private void bindRecommendedWareData(BaseViewHolder helper, HomeWares.ItemsBean item, int new_position) {
        int position=new_position%10;
        Log.d("yuan", "bindRecommendedWareData:适配器_推荐 数据 "+new_position);
        ((ExpandImageView) helper.getView(R.id.recommended_img)).setImageURI("http://"+item.getItemList().get(position).getGoods_thumb());
        helper.setText(R.id.recommended_title, item.getItemList().get(position).getGoods_name());
        helper.setText(R.id.recommended_price, item.getItemList().get(position).getShop_price()+"");
    }


//主页GridView点击事件
    @Override
    public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.icon_list_one:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_two:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_three:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_four:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_five:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_six:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_seven:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_eight:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_nine:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
            case R.id.icon_list_ten:
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
                break;
        }
        return false;
    }
}


