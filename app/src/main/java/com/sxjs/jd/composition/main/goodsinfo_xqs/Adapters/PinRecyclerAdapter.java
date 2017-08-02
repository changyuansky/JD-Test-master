package com.sxjs.jd.composition.main.goodsinfo_xqs.Adapters;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.goodsinfo_xqs.Fragments.ViewPagerAdapter;
import com.sxjs.jd.composition.main.goodsinfo_xqs.MyData.MyGoodsinfo;
import com.sxjs.jd.composition.main.goodsinfo_xqs.PinSelector.Bean;
import com.sxjs.jd.composition.main.goodsinfo_xqs.PinSelector.Constants;
import com.sxjs.jd.composition.main.goodsinfo_xqs.PinSelector.DataUtil;
import com.sxjs.jd.composition.main.goodsinfo_xqs.PinSelector.SkuAdapter;
import com.sxjs.jd.composition.main.goodsinfo_xqs.PinSelector.SkuItme;
import com.viewpagerindicator.CirclePageIndicator;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */

public class PinRecyclerAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<ImageView> imageViews;
    List<ImageView> ViewPagerImgs;
    List<String> stringList;
    private int HeaderType=0;
    private int BodyType=1;
    private int FooterType=2;
    int number=1;
    MyGoodsinfo goodsinfo;
    ///////
    String thisColor,thissize;
    PopupWindow popupWindow;
    List<SkuItme> mList;// sku数据
    List<Bean> mColorList;// 颜色列表
    List<Bean> mSizeList;// 尺码列表
    GridView gvColor;// 颜色
    GridView gvSize;// 尺码
    SkuAdapter skuColorAdapter;// 颜色适配器
    SkuAdapter skuSizeAdapter;// 尺码适配器
    String color;//
    String size;//
    TextView tvSkuName;// 显示sku
    TextView tvSkuStock;// 显示库存
    int stock = 0;// 库存
    TextView textView;
    Button gouwuche;
    ImageView imageView_select_item;
    HomeWares homeWares;
    /*
    *
    * **********************************************
    * 真实数据属性
    * */
    String goods_img;
    String goods_thumb;
    String goods_brief;
    String keywords;
    String market_price;
    String goods_number;
    String click_count;
    String goods_name;
    String goods_sn;
    String MyUrl="ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3350667841,1044584604&fm=173&s=742AB657119365D61E8A797A0300D038&w=640&h=328&img.JPEG";
    List<HomeWares.ItemsBean.ItemListBean> GoodsInfo;
    //good_sn  商品的唯一货号
    public  PinRecyclerAdapter(Activity activity,List<ImageView> imageViews,List<HomeWares.ItemsBean.ItemListBean> GoodsInfo)
    {
        this.activity=activity;
        this.imageViews=imageViews;
        this.GoodsInfo=GoodsInfo;
        inittext();
        initImage();
        Log.d("GoodsInfolist","="+GoodsInfo);
        addData();
//        MyGoodsinfo myGoodsinfo=new MyGoodsinfo(this,GlobalAppComponent.getAppComponent().getDataManager(),this);
    }
    public void inittext()
    {
        goods_brief=GoodsInfo.get(0).getGoodsBrief();
        goods_img=GoodsInfo.get(0).getGoodsImg();
        goods_sn=GoodsInfo.get(0).getGoodsSn();
        goods_thumb=GoodsInfo.get(0).getGoodsThumb();
        market_price=GoodsInfo.get(0).getMarketPrice();
        goods_name=GoodsInfo.get(0).getGoodsName();
        Log.d("inittext",""+goods_brief);
        Log.d("inittext",""+goods_img);
        Log.d("inittext",""+goods_thumb);
    }
    public void initImage()
    {
        ViewPagerImgs=new ArrayList<>();
        for (int i=0;i<5;i++)
        {
            ImageView imageView=new ImageView(activity);
            Glide.with(activity)
                    .load("http://"+goods_img)
                    .into(imageView);
            ViewPagerImgs.add(imageView);
        }
        Log.d("ViewPagerImgs.size",""+ViewPagerImgs.size());
    }
    @Override
    public int getItemViewType(int position) {
     int viewType=0;
        if(position==0){
            viewType=HeaderType;
        }
        else if (position==1)
            return viewType=FooterType;
        return viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        if (viewType==HeaderType)
        {
            holder=null;
            View view=activity.getLayoutInflater().inflate(R.layout.pin_fragment_header,null);
            MyHeaderHolder myHeaderHolder=new MyHeaderHolder(view);
            holder=myHeaderHolder;
        }
        else if (viewType==BodyType)
        {
            holder=null;
            View view=activity.getLayoutInflater().inflate(R.layout.pin_item,null);
            MyBodyHolder myBodyHolder=new MyBodyHolder(view);
            holder=myBodyHolder;
        }
        else if (viewType==FooterType)
        {
            holder=null;
            View view=activity.getLayoutInflater().inflate(R.layout.pin_fragment_footer,null);
            MyFooterHolder myBodyHolder=new MyFooterHolder(view);
            holder=myBodyHolder;
        }
            return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position==0&&holder!=null)
        {
            if(holder instanceof MyHeaderHolder){
                MyHeaderHolder headerHolder= (MyHeaderHolder) holder;
                ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(activity,ViewPagerImgs);
                headerHolder.viewPager.setAdapter(viewPagerAdapter);
                headerHolder.indicator.setViewPager(headerHolder.viewPager);
            }
        }
        else if (position==1&&holder!=null)
        {
            if(holder instanceof MyFooterHolder){
                final MyFooterHolder footerHolder= (MyFooterHolder) holder;
                    footerHolder.textjieshao.setText(goods_name+goods_brief);
                    footerHolder.textPrice.setText("￥"+ market_price);
                    footerHolder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        number++;
                        textView.setText(number+"件");
                    }
                });

                footerHolder.yixuanlayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        View layoutview=LayoutInflater.from(GlobalAppComponent.getAppComponent().getContext()).inflate(R.layout.activity_pin_selector_item,null);
                        gvSize = layoutview.findViewById(R.id.gv_size);
                        gvColor = layoutview. findViewById(R.id.gv_color);
                        tvSkuName = layoutview. findViewById(R.id.tv_sku);
                        tvSkuStock = layoutview. findViewById(R.id.tv_sku_stock);
                        gouwuche=layoutview.findViewById(R.id.gouwuche);
                        imageView_select_item=layoutview.findViewById(R.id.iv_pic);
                        Glide.with(GlobalAppComponent.getAppComponent().getContext())
                                .load("http://"+goods_thumb)
                                .into(imageView_select_item);
                        Log.d("footer123",goods_img+","+goods_thumb+","+goods_brief+","+market_price+","+goods_name+","+goods_number+","+click_count+","+goods_sn);
                        stock = DataUtil.getAllStock(mList);
                        Log.d("stock","="+stock);
                        if (stock > 0) {
                            tvSkuStock.setText("库存：" + stock + "");
                        }
                        skuColorAdapter = new SkuAdapter(mColorList, activity);
                        gvColor.setAdapter(skuColorAdapter);
                        skuColorAdapter.setItemClickListener(new SkuAdapter.onItemClickListener() {
                            @Override
                            public void onItemClick(Bean bean, int position) {
                                // TODO Auto-generated method stub
                                color = bean.getName();
                                switch (bean.getStates()) {
                                    case "0":
                                        // 清空尺码
                                        mSizeList=DataUtil.clearAdapterStates(mSizeList);
                                        skuSizeAdapter.notifyDataSetChanged();
                                        // 清空颜色
                                        mColorList=DataUtil.clearAdapterStates(mColorList);
                                        skuColorAdapter.notifyDataSetChanged();
                                        color = "";
                                        // 判断使用选中了尺码
                                        if (!TextUtils.isEmpty(size)) {
                                            // 选中尺码，计算库存
                                            stock =DataUtil.getSizeAllStock(mList,size);
                                            if (stock > 0) {
                                                tvSkuStock.setText("库存：" + stock + "");
                                            }
                                            tvSkuName.setText("请选择尺码");
                                            // 获取该尺码对应的颜色列表
                                            List<String> list = DataUtil.getColorListBySize(mList,size);
                                            if (list != null && list.size() > 0) {
                                                // 更新颜色列表
                                                mColorList = DataUtil.setSizeOrColorListStates(mColorList,list, color);
                                                skuColorAdapter.notifyDataSetChanged();
                                            }
                                            mSizeList=DataUtil.setAdapterStates(mSizeList,size);
                                            skuSizeAdapter.notifyDataSetChanged();
                                        } else {
                                            // 所有库存
                                            stock = DataUtil.getAllStock(mList);
                                            if (stock > 0) {
                                                tvSkuStock.setText("库存：" + stock + "");
                                            }
                                            tvSkuName.setText("请选择尺码,颜色分类");
                                        }
                                        break;
                                    case "1":
                                        // 选中颜色
                                        mColorList=DataUtil.updateAdapterStates(mColorList,"0", position);
                                        skuColorAdapter.notifyDataSetChanged();
                                        // 计算改颜色对应的尺码列表
                                        List<String> list = DataUtil.getSizeListByColor(mList,color);
                                        if (!TextUtils.isEmpty(size)) {
                                            // 计算改颜色与尺码对应的库存
                                            stock = DataUtil.getStockByColorAndSize(mList,color, size);
                                            tvSkuName.setText("规格:" + color + " " + size);
                                            thisColor=color;
                                            thissize=size;
                                            Log.d("color=",""+color+"'"+size);
                                            if (stock > 0) {
                                                tvSkuStock.setText("库存：" + stock + "");
                                            }
                                            if (list != null && list.size() > 0) {
                                                // 更新尺码列表
                                                mSizeList = DataUtil.setSizeOrColorListStates(mSizeList,list, size);
                                                skuSizeAdapter.notifyDataSetChanged();
                                            }
                                        } else {
                                            // 根据颜色计算库存
                                            stock = DataUtil.getColorAllStock(mList,color);
                                            if (stock > 0) {
                                                tvSkuStock.setText("库存：" + stock + "");
                                            }
                                            tvSkuName.setText("请选择尺码");
                                            if (list != null && list.size() > 0) {
                                                // 更新尺码列表
                                                mSizeList = DataUtil.setSizeOrColorListStates(mSizeList,list, "");
                                                skuSizeAdapter.notifyDataSetChanged();
                                            }
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                        });

                        skuSizeAdapter = new SkuAdapter(mSizeList, activity);
                        gvSize.setAdapter(skuSizeAdapter);
                        skuSizeAdapter.setItemClickListener(new SkuAdapter.onItemClickListener() {

                            @Override
                            public void onItemClick(Bean bean, int position) {
                                // TODO Auto-generated method stub
                                size = bean.getName();
                                switch (bean.getStates()) {
                                    case "0":
                                        // 清空尺码
                                        mSizeList=DataUtil.clearAdapterStates(mSizeList);
                                        skuSizeAdapter.notifyDataSetChanged();
                                        // 清空颜色
                                        mColorList=DataUtil.clearAdapterStates(mColorList);
                                        skuColorAdapter.notifyDataSetChanged();
                                        size = "";
                                        if (!TextUtils.isEmpty(color)) {
                                            // 计算改颜色对应的所有库存
                                            stock = DataUtil.getColorAllStock(mList,color);
                                            if (stock > 0) {
                                                tvSkuStock.setText("库存：" + stock + "");

                                            }
                                            tvSkuName.setText("请选择尺码");
                                            // 计算改颜色对应的尺码列表
                                            List<String> list = DataUtil.getSizeListByColor(mList,color);
                                            if (list != null && list.size() > 0) {
                                                // 更新尺码列表
                                                mSizeList = DataUtil.setSizeOrColorListStates(mSizeList,list, size);
                                                skuSizeAdapter.notifyDataSetChanged();
                                            }
                                            mColorList=DataUtil.setAdapterStates(mColorList,color);
                                            skuColorAdapter.notifyDataSetChanged();
                                        } else {
                                            // 获取所有库存
                                            stock = DataUtil.getAllStock(mList);
                                            if (stock > 0) {
                                                tvSkuStock.setText("库存：" + stock + "");
                                            }
                                            tvSkuName.setText("请选择尺码,颜色分类");
                                        }
                                        break;
                                    case "1":
                                        // 选中尺码
                                        mSizeList=DataUtil.updateAdapterStates(mSizeList, "0", position);
                                        skuSizeAdapter.notifyDataSetChanged();
                                        // 获取该尺码对应的颜色列表
                                        List<String> list = DataUtil.getColorListBySize(mList,size);
                                        if (!TextUtils.isEmpty(color)) {
                                            // 计算改颜色与尺码对应的库存
                                            stock = DataUtil.getStockByColorAndSize(mList,color, size);
                                            tvSkuName.setText("规格:" + color + " " + size);
                                            textView.setText("规格:" + color + " " + size);
                                            if (stock > 0) {
                                                tvSkuStock.setText("库存：" + stock + "");
                                            }
                                            if (list != null && list.size() > 0) {
                                                // 更新颜色列表
                                                mColorList = DataUtil.setSizeOrColorListStates(mColorList,list, color);
                                                skuColorAdapter.notifyDataSetChanged();
                                            }
                                        } else {
                                            // 计算改尺码的所有库存
                                            stock = DataUtil.getSizeAllStock(mList,size);
                                            if (stock > 0) {
                                                tvSkuStock.setText("库存：" + stock + "");
                                            }
                                            tvSkuName.setText("请选择颜色分类");
                                            if (list != null && list.size() > 0) {
                                                mColorList =  DataUtil.setSizeOrColorListStates(mColorList,list, "");
                                                skuColorAdapter.notifyDataSetChanged();
                                            }
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                        });
                        showBottomWindow(footerHolder.button,layoutview);

                        gouwuche.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (popupWindow!=null&&popupWindow.isShowing())
                                    popupWindow.dismiss();
                                if (!TextUtils.isEmpty(color))
                                {
                                    textView.setText(""+color+","+size);
                                }
                            }
                        });
                    }

                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }



//初始化商品属性
//    @Override
//    public void getgoodsinfo(GoodsPinInfo homeWares) {
        // goods_img,goods_thumb,goods_brief,keywords,
        //        market_price,goods_number,click_count,goods_name,goods_sn;



    public class MyHeaderHolder extends RecyclerView.ViewHolder {
        ViewPager viewPager;
        CirclePageIndicator indicator;

        public MyHeaderHolder(View itemView) {
            super(itemView);
            viewPager=(ViewPager) itemView.findViewById(R.id.pin_VP);
            indicator=(CirclePageIndicator) itemView.findViewById(R.id.Indicator);
        }
    }
    public class MyBodyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyBodyHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.pin_t);
        }
    }
    public class MyFooterHolder extends RecyclerView.ViewHolder {
        Button button;
        TextView textPrice,textjieshao;
        LinearLayout yixuanlayout;

        public MyFooterHolder(View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.btn_yixuan);
            textView=itemView.findViewById(R.id.text_yixuan);
            yixuanlayout=itemView.findViewById(R.id.layout_yixuanxqs);
            textPrice=itemView.findViewById(R.id.text_pin_jiage);
            textjieshao=itemView.findViewById(R.id.text_pin_jieshao);
        }
    }
    public void showBottomWindow( View kongjian, View layouut)
    {

        popupWindow=new PopupWindow(layouut);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF302F2F")));
        popupWindow.setAnimationStyle(R.style.Animation);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 需要设置一下此参数，点击外边可消失
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(kongjian, Gravity.BOTTOM,0,0);
        //设置弹出后  屏幕的颜色
//        WindowManager.LayoutParams lp=getWindow().getAttributes();
        WindowManager.LayoutParams lp=activity.getWindow().getAttributes();
        lp.alpha=0.7f;
//        popupWindow.setAttributes(lp);
        activity.getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp=activity.getWindow().getAttributes();
                lp.alpha=1f;
                activity.getWindow().setAttributes(lp);
            }
        });
    }
    /**
     * 模拟数据
     */
    private void addData() {
        mList = new ArrayList<SkuItme>();
        mColorList = new ArrayList<Bean>();
        mSizeList = new ArrayList<Bean>();
        String[] colorArr = Constants.colorArr;
        String[] sizeArr = Constants.sizeArr;
        int color = colorArr.length;
        int size = sizeArr.length;
        for (int i = 0; i < color; i++) {
            Bean bean = new Bean();
            bean.setName(colorArr[i]);
            bean.setStates("1");
            mColorList.add(bean);
        }
        for (int i = 0; i < size; i++) {
            Bean bean = new Bean();
            bean.setName(sizeArr[i]);
            bean.setStates("1");
            mSizeList.add(bean);
        }

        String color0 = colorArr[0];
        String size0 = sizeArr[0];
        String color1 = colorArr[1];
        String size1 = sizeArr[1];
        String color2 = colorArr[2];
        String size2 = sizeArr[2];
        String color3 = colorArr[3];
        String size3 = sizeArr[3];
        String color4 = colorArr[4];
        String size4 = sizeArr[4];
        String size5 = sizeArr[5];
        SkuItme item0 = new SkuItme();
        item0.setId("1");
        item0.setSkuColor(color0);
        item0.setSkuSize(size0);
        item0.setSkuStock(10);
        mList.add(item0);
        SkuItme item1 = new SkuItme();
        item1.setId("2");
        item1.setSkuColor(color0);
        item1.setSkuSize(size1);
        item1.setSkuStock(1);
        mList.add(item1);
        SkuItme item2 = new SkuItme();
        item2.setId("3");
        item2.setSkuColor(color1);
        item2.setSkuSize(size0);
        item2.setSkuStock(12);
        mList.add(item2);
        SkuItme item3 = new SkuItme();
        item3.setId("4");
        item3.setSkuColor(color1);
        item3.setSkuSize(size2);
        item3.setSkuStock(123);
        mList.add(item3);
        SkuItme item4 = new SkuItme();
        item4.setId("5");
        item4.setSkuColor(color1);
        item4.setSkuSize(size1);
        item4.setSkuStock(53);
        mList.add(item4);
        SkuItme item5 = new SkuItme();
        item5.setId("6");
        item5.setSkuColor(color2);
        item5.setSkuSize(size1);
        item5.setSkuStock(13);
        mList.add(item5);
        SkuItme item6 = new SkuItme();
        item6.setId("7");
        item6.setSkuColor(color0);
        item6.setSkuSize(size3);
        item6.setSkuStock(18);
        mList.add(item6);
        SkuItme item7 = new SkuItme();
        item7.setId("8");
        item7.setSkuColor(color2);
        item7.setSkuSize(size3);
        item7.setSkuStock(14);
        mList.add(item7);
        SkuItme item8 = new SkuItme();
        item8.setId("9");
        item8.setSkuColor(color1);
        item8.setSkuSize(size3);
        item8.setSkuStock(22);
        mList.add(item8);
        SkuItme item9 = new SkuItme();
        item9.setId("10");
        item9.setSkuColor(color0);
        item9.setSkuSize(size4);
        item9.setSkuStock(29);
        mList.add(item9);
        SkuItme item10 = new SkuItme();
        item10.setId("11");
        item10.setSkuColor(color2);
        item10.setSkuSize(size5);
        item10.setSkuStock(64);
        mList.add(item10);
        SkuItme item11 = new SkuItme();
        item11.setId("12");
        item11.setSkuColor(color3);
        item11.setSkuSize(size2);
        item11.setSkuStock(70);
        mList.add(item11);
        SkuItme item12 = new SkuItme();
        item12.setId("13");
        item12.setSkuColor(color4);
        item12.setSkuSize(size0);
        item12.setSkuStock(80);
        mList.add(item12);
        SkuItme item13 = new SkuItme();
        item13.setId("14");
        item13.setSkuColor(color3);
        item13.setSkuSize(size4);
        item13.setSkuStock(35);
        mList.add(item13);
        SkuItme item14 = new SkuItme();
        item14.setId("15");
        item14.setSkuColor(color4);
        item14.setSkuSize(size1);
        item14.setSkuStock(62);
        mList.add(item14);
        SkuItme item15 = new SkuItme();
        item15.setId("16");
        item15.setSkuColor(color3);
        item15.setSkuSize(size5);
        item15.setSkuStock(41);
        mList.add(item15);
        SkuItme item16 = new SkuItme();
        item16.setId("17");
        item16.setSkuColor(color1);
        item16.setSkuSize(size5);
        item16.setSkuStock(39);
        mList.add(item16);
        SkuItme item17 = new SkuItme();
        item17.setId("18");
        item17.setSkuColor(color4);
        item17.setSkuSize(size5);
        item17.setSkuStock(37);
        mList.add(item17);
        SkuItme item18 = new SkuItme();
        item18.setId("19");
        item18.setSkuColor(color4);
        item18.setSkuSize(size2);
        item18.setSkuStock(44);
        mList.add(item18);
        SkuItme item19 = new SkuItme();
        item19.setId("20");
        item19.setSkuColor(color4);
        item19.setSkuSize(size3);
        item19.setSkuStock(61);
        mList.add(item19);
        Log.d("list",""+mList+","+mColorList+","+mSizeList);
    }

}
