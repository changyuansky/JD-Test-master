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
import com.sxjs.common.data.Constant;
import com.sxjs.common.widget.autoscrollviewpager.BGABanner;
import com.sxjs.common.widget.imageview.ExpandImageView;
import com.sxjs.jd.R;



/**
 * @author admin 数据绑定未进行详细的数据验证，再实际使用中不可取
 */
public class HomeMultiple_banner_RecycleAdapter extends BaseMultiItemQuickAdapter<HomeBannerImg.ItemsBean , BaseViewHolder> implements BaseQuickAdapter.SpanSizeLookup {

    private CountDownTimer timer;
    private int maxHasLoadPosition;
    private boolean logSwitch=false;
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

    public HomeMultiple_banner_RecycleAdapter() {
        setSpanSizeLookup(this);
        addItemType(Constant.TYPE_TOP_BANNER, R.layout.homerecycle_item_top_banner);
        if (logSwitch) Log.d("yuan", "HomeMultiple_banner_RecycleAdapter:进入Banner适配器了");
    }

    /**
     * 数据绑定未进行详细的数据验证，在实际使用中不可取
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     * @param position
     */
    @Override
    protected void convert(BaseViewHolder helper, HomeBannerImg.ItemsBean item, int position) {
        if (logSwitch)Log.d("yuan", "HomeMultiple_banner_RecycleAdapter:进入convert");
        if (listener != null) {
            listener.currentPosition(position);
        }
        if (maxHasLoadPosition < position) {
            maxHasLoadPosition = position;
        }
        if ("topBanner".equals(item.itemType)) {
            bindTopBannerData(helper, item, position);
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
    private void bindTopBannerData(BaseViewHolder helper, final HomeBannerImg.ItemsBean item, int position) {
        if (logSwitch) Log.d("yuan", "HomeMultiple_banner_RecycleAdapter:bindTopBannerData");
        BGABanner banner = helper.getView(R.id.banner);
        banner.setDelegate(new BGABanner.Delegate<View, HomeBannerImg.ItemsBean.ItemListBean>() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, HomeBannerImg.ItemsBean.ItemListBean model, int position) {
                Toast.makeText(itemView.getContext(), "" +model.getAdName(), Toast.LENGTH_SHORT).show();
            }
        });
        banner.setAdapter(new BGABanner.Adapter<View, HomeBannerImg.ItemsBean.ItemListBean>() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, HomeBannerImg.ItemsBean.ItemListBean model, int position) {
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv_item_fresco_content);
                simpleDraweeView.setImageURI("http://"+Uri.parse(model.getAdCode()));
            }
        });

        banner.setData(R.layout.homerecycle_top_banner_content, item.getItemList(), null);
    }

}


