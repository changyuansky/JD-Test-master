package com.sxjs.jd.composition.main.homefragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.sxjs.common.CommonConfig;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.data.Constant;
import com.sxjs.common.widget.imageview.ExpandImageView;
import com.sxjs.jd.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ezy.ui.view.BannerView;

import static com.sxjs.jd.composition.main.homefragment.SpikeDividerItemDecoration.HORIZONTAL_LIST;

/**
 * Created by Administrator on 2017/7/27.
 */

public class MyHomeAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    static Context context;
    List<HomeWares.ItemsBean.ItemListBean> itemListBeanList;
    List<HomeWares.ItemsBean.ItemListBean> BargainitemListBeanList;
    List<HomeWares.ItemsBean.ItemListBean> hBi_Bg;
    private final int BANNER_TYPE= Constant.TYPE_TOP_BANNER;
    private final int SPIKE_TYPE= Constant.TYPE_JD_SPIKE_CONTENT;
    private final int RECOMMEND_TYPE= Constant.TYPE_RECOMMENDED_WARE;
    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }


    public static class BannerViewFactory implements BannerView.ViewFactory<HomeWares.ItemsBean.ItemListBean> {
        @Override
        public View create(HomeWares.ItemsBean.ItemListBean item, int position, ViewGroup container) {
            ImageView iv = new ImageView(container.getContext());
            Glide.with(context)
                    .load("http://" + item.getAdCode())
                    .into(iv);
            return iv;
        }
    }

    public MyHomeAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<HomeWares.ItemsBean.ItemListBean> itemListBeanList){
        this.itemListBeanList.addAll(itemListBeanList);
        notifyDataSetChanged();
    }
    public void setRecommendWares(List<HomeWares.ItemsBean.ItemListBean> itemList){
        this.itemListBeanList=itemList;
    }
    public void setBargainGoods(List<HomeWares.ItemsBean.ItemListBean> itemList){
        this.BargainitemListBeanList=itemList;
    }
    public void setHomeBannerImgAndBargainGoods(List<HomeWares.ItemsBean.ItemListBean> hBi_Bg){
        this.hBi_Bg=hBi_Bg;
    }
    public List<HomeWares.ItemsBean.ItemListBean> getRecommendWareData(){
        return this.itemListBeanList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_TYPE;
        }else if (position == 1){
            return SPIKE_TYPE;
        }else
        return RECOMMEND_TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BANNER_TYPE:
                View bannerview = LayoutInflater.from(context).inflate(R.layout.homerecycle_item_top_banner, parent, false);
                return new BannerHolder(bannerview);
            case SPIKE_TYPE:
                View spikeview = LayoutInflater.from(context).inflate(R.layout.homerecycle_item_spike_content, parent, false);
                return new SpikerHolder(spikeview);
            case RECOMMEND_TYPE:
                View view = LayoutInflater.from(context).inflate(R.layout.homerecycle_item_type_recommented_ware, parent, false);
                view.setOnClickListener(this);
                return new HomeHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position==0){
            BannerHolder bannerHolder =(BannerHolder) holder;
            bannerHolder.banner.setViewFactory(new MyHomeAdapter.BannerViewFactory());
            bannerHolder.banner.setDataList(hBi_Bg);
            bannerHolder.banner.start();
        }else if (position ==1){
            SpikerHolder spikerHolder =(SpikerHolder) holder;
            iconListOnclick(spikerHolder);
            spikerHolder.spikeRecyvlerView.addItemDecoration(new SpikeDividerItemDecoration(context, HORIZONTAL_LIST));
            spikerHolder.spikeRecyvlerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            MySpikeAdapter spikerAdapter = new MySpikeAdapter(context,BargainitemListBeanList);
            spikerHolder.spikeRecyvlerView.setAdapter(spikerAdapter);
            spikerAdapter.setOnItemClickListener(new MySpikeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    //Toast.makeText(context, "热卖商品位置="+position, Toast.LENGTH_SHORT).show();
                    int goodsId = BargainitemListBeanList.get(position).getGoodsId();
                    ARouter.getInstance().build("/xqs/mainfragmentactivity")
                            .withInt(CommonConfig.GOODSINFO_KEY,goodsId)
                            .navigation();
                }
            });
        }else {
            HomeHolder homeHolder =(HomeHolder) holder;
            int realPosition = position-2;
            Glide.with(context)
                    .load("http://" + itemListBeanList.get(realPosition).getGoodsImg())
                    .into(homeHolder.recommended_img);
//            Log.d("yuan", "推荐商品位置=" + position);
            homeHolder.recommended_price.setText(itemListBeanList.get(realPosition).getShopPrice() + "");
            homeHolder.recommended_title.setText(itemListBeanList.get(realPosition).getGoodsName());
            //将position保存在itemView的Tag中，以便点击时进行获取
            homeHolder.itemView.setTag(realPosition);
        }
    }

    @Override
    public int getItemCount() {
        return itemListBeanList.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder{
        ExpandImageView recommended_img;
        TextView recommended_title;
        TextView recommended_price;
        public HomeHolder(View itemView) {
            super(itemView);
            recommended_img = itemView.findViewById(R.id.recommended_img);
            recommended_title = itemView.findViewById(R.id.recommended_title);
            recommended_price = itemView.findViewById(R.id.recommended_price);
        }
    }
    class SpikerHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.spike_content_view)
        RecyclerView spikeRecyvlerView;
        @BindView(R.id.icon_list_one)
        ExpandImageView icon_list_one ;
        @BindView(R.id.icon_list_two)
        ExpandImageView icon_list_two ;
        @BindView(R.id.icon_list_three)
        ExpandImageView icon_list_three;
        @BindView(R.id.icon_list_four)
        ExpandImageView icon_list_four;
        @BindView(R.id.icon_list_six)
        ExpandImageView icon_list_six ;
        @BindView(R.id.icon_list_seven)
        ExpandImageView icon_list_seven;
        @BindView(R.id.icon_list_eight)
        ExpandImageView icon_list_eight;
        @BindView(R.id.icon_list_nine)
        ExpandImageView icon_list_nine;
        public SpikerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class BannerHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.banner)
        BannerView banner;
        public BannerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    private void iconListOnclick(SpikerHolder spikerHolder){
        final MyToast myToast = new MyToast(context);
        spikerHolder.icon_list_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
            }
        });
        spikerHolder.icon_list_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myToast.showToast("--登录界面--");
                ARouter.getInstance().build("/test/login").navigation();
            }
        });
        spikerHolder.icon_list_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myToast.showToast("购书车");
//                ARouter.getInstance().build("/order/orderactivity").navigation();
            }
        });
        spikerHolder.icon_list_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myToast.showToast("借书车");
//                ARouter.getInstance().build("/order/orderactivity").navigation();
            }
        });
        spikerHolder.icon_list_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myToast.showToast("图书馆");
//                ARouter.getInstance().build("/order/orderactivity").navigation();
            }
        });
        spikerHolder.icon_list_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/order/orderactivity").navigation();
            }
        });
        spikerHolder.icon_list_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myToast.showToast("跳转到“我的”");
                //ARouter.getInstance().build("/order/orderactivity").navigation();
            }
        });
        spikerHolder.icon_list_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myToast.showToast("跳转到“收藏”");
//                ARouter.getInstance().build("/order/orderactivity").navigation();
            }
        });
    }
}
