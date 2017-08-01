package com.sxjs.jd.composition.main.mine;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.base.BaseFragment;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.mine.RecyclerViewUtils.MyAdapter;
import com.sxjs.jd.composition.main.mine.RecyclerViewUtils.MyDecoration;
import com.sxjs.jd.composition.main.mine.RecyclerViewUtils.MyOnScrollListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.observers.DisposableObserver;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Administrator on 2017/7/30.
 */

public class MyFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private GridLayoutManager layoutManager;
    private MyDecoration decoration;
    private View view;
    private SwipeRefreshLayout refreshLayout;
    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mine,container,false);
         ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //recyclerview 的
        recyclerView = (RecyclerView) getView().findViewById(R.id.Recyclerview);
        layoutManager = new GridLayoutManager(getActivity(),2);
        decoration = new MyDecoration(getActivity());
        Log.d(TAG, "onCreate: 初始化完成");

        GlobalAppComponent.getAppComponent().getDataManager().getHomeWares(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {

                Log.d(TAG, "onNext: 数据申请成功");

                adapter = new MyAdapter(getActivity(),homeWares.getItems().get(0).getItemList());
                layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        switch (adapter.getItemViewType(position)){
                            case 0:
                                return 2;
                            case 1:
                                return 1;
                            default:
                                return -1;
                        }
                    }
                });
                recyclerView.addOnScrollListener(new MyOnScrollListener(getActivity(),adapter));
                recyclerView.setAdapter(adapter);
                recyclerView.addItemDecoration(decoration);
                recyclerView.setLayoutManager(layoutManager);

                Log.d(TAG, "onNext: 商品列表成功");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: 网络访问出错");
            }

            @Override
            public void onComplete() {

            }
        }, 1, false);

        //新功能
        refreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefreshLayout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);

                Toast.makeText(getActivity(),"刷新成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @OnClick({R.id.personal_order_oder,R.id.person_head_person})
//    public void imagclick(View view1) {
//        switch (view1.getId()) {
//            case R.id.personal_order_oder:
//                Log.d("33333", "imagclick: 跳转订单");
//                ARouter.getInstance().build("/order/OrderActivity").navigation();
//                break;
//        }
//
//    }

    public void recommend(View view){
        switch (view.getId()){
            //首页图片人头部分
            case R.id.person_head_person:
                Toast.makeText(getContext(),"成功",Toast.LENGTH_SHORT).show();
                break;
            //首页图片用户名
            case R.id.person_head_name:
                break;
            //首页图片注册会员
            case R.id.person_head_member:
                break;
            //首页图片小白信用
            case R.id.person_head_credit:
                break;
            //图片账户管理
            case R.id.account_rlayout:
                break;
            //待付款
            case R.id.personal_order_waitpay_layout:
                Toast.makeText(getContext(),"没有更多数据了",Toast.LENGTH_SHORT).show();
                break;
            //待收获
            case R.id.personal_order_waitreceive_layout:
                break;
            //待评价
            case R.id.personal_order_waitcomment_layout:
                break;
            //退换/售后
            case R.id.personal_order_returned:
                break;
            //我的订单
            case R.id.personal_order_oder:
                break;
            //京豆
            case R.id.personal_money_bean:
                break;
            //优惠券
            case R.id.personal_money_coupon:
                break;
            //白条
            case R.id.personal_money_lous:
                break;
            //京东小金库
            case R.id.personal_money_valut:
                break;
            //我的钱包
            case R.id.personal_monety:
                break;
            //商品关注
            case R.id.commodity_concerns:
                break;
            //店铺关注
            case R.id.shop_attention:
                break;
            //浏览记录
            case R.id.browse_log:
                break;
            //客户服务
            case R.id.customer_service:
                break;
            //我的活动
            case R.id.me_activity:
                break;
            //社区
            case R.id.community:
                break;
            //京东超市
            case R.id.jd_supermarket:
                break;
            //排行榜
            case R.id.ranking_list:
                break;
        }
    }

}
