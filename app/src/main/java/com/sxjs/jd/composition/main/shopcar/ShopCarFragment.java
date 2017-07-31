package com.sxjs.jd.composition.main.shopcar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.base.BaseFragment;
import com.sxjs.common.bean.ShopCar;
import com.sxjs.common.util.NetworkUtil;
import com.sxjs.jd.R;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import io.reactivex.observers.DisposableObserver;


 public class ShopCarFragment extends BaseFragment {
     private View mEmtryView;
     private View mNonetView;
     private View mItemView;
     private RelativeLayout mrl_edit;
     private SwipeRefreshLayout swipeRefreshLayout_nonet;
     private SwipeRefreshLayout swipeRefreshLayout_null;
     private SwipeRefreshLayout  swipeRefreshLayout_item;
     private TextView tvShopCartSelect;//全选按钮
     private RecyclerView mRecyclerView;
     private LinearLayoutManager mLayoutManager;
     private ShopCart1Adapter mAdapter;
     private String TAG = "newubru";
     private List<ShopCar.ItemsBean> zAllOrderList = new ArrayList<>();//购物车liist
     private List<ShopCar.ItemsBean> mAllOrderList = new ArrayList<>();//购物车liist
     private ArrayList<ShopCar.ItemsBean.ItemListBean> mGoPayList = new ArrayList<>();//支付list
     public TextView tvShopCartTotalNum,tvShopCartTotalPrice;//提交 全选 总计金额
     private int mCount,mPosition;
     private float mTotalPrice1;
     private boolean mSelect;
     private ProgressBar progressBar;
     private TextView edit;
     private TextView finish;
     private ImageView information;
     private boolean isedit=false;
     private TextView edit_share;
     private TextView edit_move;
     private TextView edit_detle;
     private List<ShopCar.ItemsBean.ItemListBean> detlelist = new ArrayList<>();
     private List<Integer> mdetlelist = new ArrayList<>();
     private List<Integer> detl = new ArrayList<>();
     private View carview;
     private Context mcontext;
     public static ShopCarFragment newInstance() {
         return new ShopCarFragment();
     }


     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         carview = inflater.inflate(R.layout.fragment_car,container,false);
         ARouter.init(getActivity().getApplication());
         onCreate();
         return carview;
     }

    private void onCreate() {
        mcontext = GlobalAppComponent.getAppComponent().getContext();
        //获取不同状态时布局
        mEmtryView = (View) carview.findViewById(R.id.carrecycle_item_null);//空数据布局
        mNonetView = (View) carview.findViewById(R.id.carrecycle_nonet);//无网络布局
        mItemView = (View) carview.findViewById(R.id.carrecycle_item);//有数据布局
        //默认隐藏空数据布局 无网络布局
        mNonetView.setVisibility(View.GONE);
        mEmtryView.setVisibility(View.GONE);
        //控件获取
        progressBar=(ProgressBar)carview.findViewById(R.id.pb_fc);
        progressBar.setVisibility(View.INVISIBLE);
        mRecyclerView = (RecyclerView)carview.findViewById(R.id.car_recyclerView);
        tvShopCartSelect=(TextView)carview.findViewById(R.id.ivSelectAll);
        tvShopCartTotalPrice = (TextView) carview.findViewById(R.id.tvCountMoney);//总金额
        tvShopCartTotalNum = (TextView) carview.findViewById(R.id.btnSettle);//总计件数
        edit = (TextView) carview.findViewById(R.id.tv_bianji);//编辑
        finish = (TextView) carview.findViewById(R.id.tv_finish);
        information = (ImageView) carview.findViewById(R.id.advisory_img);//消息
        mrl_edit = (RelativeLayout) carview.findViewById(R.id.rl_edit);
        edit_share = (TextView) carview.findViewById(R.id.tv_share);
        edit_detle = (TextView) carview.findViewById(R.id.tv_detle);
        edit_move = (TextView) carview.findViewById(R.id.tv_move);
        //获取swipeRefreshLayout
        swipeRefreshLayout_nonet = (SwipeRefreshLayout) carview.findViewById(R.id.car_nonet_pull_refresh_header);//有数据布局
        swipeRefreshLayout_null = (SwipeRefreshLayout) carview.findViewById(R.id.car_null_pull_refresh_header);//无网络布局
        swipeRefreshLayout_item=(SwipeRefreshLayout) carview.findViewById(R.id.car_item_pull_refresh_header);//有数据布局
        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(mcontext);
        mRecyclerView.setLayoutManager(mLayoutManager);
       //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        mrl_edit.setVisibility(View.GONE);
        finish.setVisibility(View.GONE);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isedit=!isedit;
                if(isedit){
                    edit.setText("完成");
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_unselected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                    for(int i = 0;i < mAllOrderList.get(0).getItemList().size();i++) {
                        mAllOrderList.get(0).getItemList().get(i).setSelect(false);
                    }
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                    mAdapter.notifyDataSetChanged();
                    mrl_edit.setVisibility(View.VISIBLE);
                }else {
                    edit.setText("编辑");
                    mrl_edit.setVisibility(View.GONE);
                    if(detlelist.size()!=0){
                               initData();
                                mAdapter.notifyDataSetChanged();
                }else {
                }
                }
            }
        });

        edit_detle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdetlelist.clear();
                for(int i = 0;i < mAllOrderList.get(0).getItemList().size();i++) {
                    if(mAllOrderList.get(0).getItemList().get(i).getIsSelect()){
                        mdetlelist.add(mAllOrderList.get(0).getItemList().get(i).getUserId());
                        detlelist.add(mAllOrderList.get(0).getItemList().get(i));
                    }
                }
                if(mdetlelist.size()!=0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                    builder.setMessage("确定要删除这"+mdetlelist.size()+"种商品吗?");
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //上交删除列 如果已删除
                            getAppComponent().getDataManager().postDeleteCars(new DisposableObserver<ShopCar>() {
                                @Override
                                public void onNext(ShopCar shopCar) {
                                    if (shopCar.code!=null){
                                        //若已删除遍历detlelist删除mlist中id相同者
                                        for(int i = 0;i < detlelist.size();i++) {
                                            for(int j = 0;j < mAllOrderList.get(0).getItemList().size();j++) {
                                                if(mAllOrderList.get(0).getItemList().get(j).getGoodsId()==detlelist.get(i).getGoodsId()){
                                                    if(mAllOrderList.get(0).getItemList().get(j).getGoodsNumber()>detlelist.get(i).getGoodsNumber()){
                                                        mAllOrderList.get(0).getItemList().get(j).setGoodsNumber(mAllOrderList.get(0).getItemList().get(j).getGoodsNumber()-detlelist.get(i).getGoodsNumber());
                                                    }
                                                    else{
                                                       mAllOrderList.get(0).getItemList().remove(j);
                                                    }
                                                }
                                            }
                                        }
                                        mAdapter.notifyDataSetChanged();
                                    }
                                    else{
                                        //若未删除提示删除失败
                                        Toast.makeText(mcontext,"服务器忙稍后再试",Toast.LENGTH_SHORT).show();
                                    }

                                }

                                @Override
                                public void onError(Throwable e) {
                                    Toast.makeText(mcontext ,"onError",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onComplete() {

                                }

                            },mdetlelist);

                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.create().show();
                }
                else{
                }
            }

        });

        edit_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"跳转至分享页面",Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/test/activity2").navigation();
            }
        });

        edit_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"跳转至移入关注页面",Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/test/activity2").navigation();
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"跳转至消息中心页面",Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/test/activity2").navigation();
            }
        });

        //是否有网判断
        isConnectNet();
        //跳转页面
        tvShopCartTotalNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"跳转至结算页面",Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/test/activity2").navigation();
            }
        });

        //设置不同头布局的下拉刷新效果
        swipeRefreshLayout_nonet.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //尝试加载数据
                isConnectNet();
                swipeRefreshLayout_nonet.setRefreshing(false);
            }
        });
        swipeRefreshLayout_null.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                    initData();
                swipeRefreshLayout_null.setRefreshing(false);
            }
        });
        swipeRefreshLayout_item.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout_item.setRefreshing(false);
                initData();
            }
        });
    }



     //网络连接与否
    private void isConnectNet() {

        if (!NetworkUtil.isNetworkAvailable(mcontext)) {
            mNonetView.setVisibility(View.VISIBLE);
            mEmtryView.setVisibility(View.GONE);
            mItemView.setVisibility(View.GONE);
        }
       else {
                //从服务器获取数据
                initData();
            }

    }

    //网上获取数据
    private void initData(){
        getAppComponent().getDataManager().getShopCarInfo(new DisposableObserver<ShopCar>() {
            @Override
            public void onNext(ShopCar shopCar) {
                if(shopCar.code.equals("200")&&shopCar.getItems().get(0).getItemList().size()!=0){
                    mNonetView.setVisibility(View.GONE);
                    mEmtryView.setVisibility(View.GONE);
                    mItemView.setVisibility(View.VISIBLE);
                        //绑定数据
                        databind(shopCar.getItems());
                }
                else{
                    mNonetView.setVisibility(View.GONE);
                    mEmtryView.setVisibility(View.VISIBLE);
                    mItemView.setVisibility(View.GONE);
                    edit.setVisibility(View.GONE);
                }
            }

            @Override
            public void onError(Throwable e) {
                edit.setVisibility(View.GONE);
                Toast.makeText(mcontext,"获取数据失败，请稍后再试...",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
            }

        },7,1,false);

    }

    //数据绑定
    private  void databind( List<ShopCar.ItemsBean> list) {

        mAllOrderList=list;
        mAdapter=new ShopCart1Adapter(mcontext,mAllOrderList);
        mRecyclerView.setAdapter(mAdapter);
        //长按删除商品接口
        mAdapter.setOnItemLongClickListener(new ShopCart1Adapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                builder.setMessage("确定删除商品吗?");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        detl.clear();
                        detl.add(mAllOrderList.get(0).getItemList().get(position).getUserId());
                        getAppComponent().getDataManager().postDeleteCars(new DisposableObserver<ShopCar>() {
                            @Override
                            public void onNext(ShopCar shopCar) {
                                if (shopCar.code!=null){
                                    mAllOrderList.get(0).getItemList().remove(position);
                                    if(mAllOrderList.get(0).getItemList().size()==0){
                                        mNonetView.setVisibility(View.GONE);
                                        mEmtryView.setVisibility(View.VISIBLE);
                                        mItemView.setVisibility(View.GONE);
                                    }
                                    else{
                                    }
                                    mAdapter.notifyDataSetChanged();
                                }
                                else{
                                    //若未删除提示删除失败
                                    Toast.makeText(mcontext,"服务器忙稍后再试",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        },detl);
                        mAdapter.notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });

        //修改数量接口加
        mAdapter.setOnEditClickListener(new ShopCart1Adapter.OnEditClickListener() {
            @Override
            public void onEditClick(final int position, int cartid, final int count) {
                progressBar.setVisibility(View.VISIBLE);
                mCount = count;
                mPosition = position;
                //实时传输数据
                AddShaopCar addShaopCar=new AddShaopCar();
                addShaopCar.setRecId(mAllOrderList.get(0).getItemList().get(position).getRecId());
                addShaopCar.setUserId(mAllOrderList.get(0).getItemList().get(position).getUserId());
                addShaopCar.setGoodsId(mAllOrderList.get(0).getItemList().get(position).getGoodsId());
                addShaopCar.setGoodsSn(mAllOrderList.get(0).getItemList().get(position).getGoodsSn());
                addShaopCar.setProductId(mAllOrderList.get(0).getItemList().get(position).getProductId());
                addShaopCar.setGoodsName(mAllOrderList.get(0).getItemList().get(position).getGoodsName());
                addShaopCar.setMarketPrice(new BigDecimal(mAllOrderList.get(0).getItemList().get(position).getMarketPrice()));
                addShaopCar.setGoodsPrice(new BigDecimal(mAllOrderList.get(0).getItemList().get(position).getGoodsPrice()));
                addShaopCar.setGoodsNumber((short)1);
                addShaopCar.setGoodsAttrId(mAllOrderList.get(0).getItemList().get(position).getGoodsAttrId());
                addShaopCar.setAddTime(new Date(System.currentTimeMillis()));
                addShaopCar.setGoodsAttr(mAllOrderList.get(0).getItemList().get(position).getGoodsAttr());
                addShaopCar.setSupplier_name(mAllOrderList.get(0).getItemList().get(position).getSupplier_name());
                addShaopCar.setGoodsImg(mAllOrderList.get(0).getItemList().get(position).getGoodsImg());
                getAppComponent().getDataManager().postAddCar(new DisposableObserver<ShopCar>() {
                    @Override
                    public void onNext(ShopCar shopCar) {

                        progressBar.setVisibility(View.GONE);
                        if(shopCar.code==null){
                            Toast.makeText(mcontext,"服务器忙稍后再试",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            mAllOrderList.get(0).getItemList().get(position).setGoodsNumber(count);
                            mAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(mcontext,"提交失败",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                },addShaopCar);

            }
        });

        //修改数量接口减
        mAdapter.setOnEditClickListenerjian(new ShopCart1Adapter.OnEditClickListenerjian() {
            @Override
            public void onEditClickjian(final int position, int cartid, final int count) {
                progressBar.setVisibility(View.VISIBLE);
                mCount = count;
                mPosition = position;
                getAppComponent().getDataManager().getDeleteCarByRecId(new DisposableObserver<ShopCar>() {
                    @Override
                    public void onNext(ShopCar shopCar) {
                        if(shopCar.code.equals("200")){
                            progressBar.setVisibility(View.INVISIBLE);
                            mAllOrderList.get(0).getItemList().get(position).setGoodsNumber(count);
                            mAdapter.notifyDataSetChanged();
                        }
                        else{
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(mcontext,"服务器忙稍后再试",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(mcontext,"提交失败",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                },mAllOrderList.get(0).getItemList().get(position).getRecId());
            }
        });

        ////实时监控全选按钮并对总价和总件数赋值
        mAdapter.setResfreshListener(new ShopCart1Adapter.OnResfreshListener() {
            @Override
            public void onResfresh(boolean isSelect) {

                mSelect = isSelect;
                if(isSelect){
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_selected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                }else {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_unselected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                }
                int mTotalPrice = 0;
                int mTotalNum = 0;
                mTotalPrice1 = 0;
                mGoPayList.clear();
                for(int i = 0;i < mAllOrderList.get(0).getItemList().size(); i++)
                    if(mAllOrderList.get(0).getItemList().get(i).getIsSelect()) {
                        mTotalPrice +=mAllOrderList.get(0).getItemList().get(i).getGoodsPrice() * mAllOrderList.get(0).getItemList().get(i).getGoodsNumber();
                        mTotalNum += mAllOrderList.get(0).getItemList().get(i).getGoodsNumber();
                        mGoPayList.add(mAllOrderList.get(0).getItemList().get(i));
                    }
                mTotalPrice1 = mTotalPrice;
                tvShopCartTotalNum.setText("去结算（" + mTotalNum + "）");
                tvShopCartTotalPrice.setText("总价：" + mTotalPrice);

            }
        });

        //全选
        tvShopCartSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSelect = !mSelect;
                if(mSelect){
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_selected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                    for(int i = 0;i < mAllOrderList.get(0).getItemList().size();i++){
                        mAllOrderList.get(0).getItemList().get(i).setSelect(true);
                    }
                }else{
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_unselected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                    for(int i = 0;i < mAllOrderList.get(0).getItemList().size();i++){
                        mAllOrderList.get(0).getItemList().get(i).setSelect(false);
                    }
                }
                mAdapter.notifyDataSetChanged();

            }
        });

    }

 }
