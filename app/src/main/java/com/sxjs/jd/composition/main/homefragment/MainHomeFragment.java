package com.sxjs.jd.composition.main.homefragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sxjs.common.CommonConfig;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.base.rxjava.ErrorDisposableObserver;
import com.sxjs.common.bean.HomeBannerImg;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.model.DataManager;
import com.sxjs.common.util.NetworkUtil;
import com.sxjs.common.util.ScreenUtil;
import com.sxjs.common.widget.headerview.JDHeaderView;
import com.sxjs.common.widget.pulltorefresh.PtrFrameLayout;
import com.sxjs.common.widget.pulltorefresh.PtrHandler;
import com.sxjs.jd.R;
import com.sxjs.common.base.BaseFragment;
import com.sxjs.jd.composition.main.MainActivity;


import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 作者：admin on 2017/3/15 10:47.
 */
public class MainHomeFragment extends BaseFragment {
    /**
     * 改变titlebar中icon颜色时的距离
     */
    private static int DISTANCE_WHEN_TO_SELECTED = 40;
    @BindView(R.id.scanning_layout)
    LinearLayout scanningLayout;
    @BindView(R.id.advisory_layout)
    LinearLayout advisoryLayout;
    @BindView(R.id.home_title_bar_layout)
    FrameLayout homeTitleBarLayout;
    @BindView(R.id.home_title_bar_bg_view)
    View homeTitleBarBgView;
    RecyclerView homerecyclerView;
    private View rootView = null;
    private int distanceY;
    private MainActivity activity;
    private DataManager mDataManager;
    private Context context;
    private RefreshLayout refreshLayout;
    private MyHomeAdapter homeAdapter;
    private int pageindex=1;
    private int pageindextemp=1;
    private boolean logswitch=true;
    private View mNonetView;
    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recycle, container, false);
        activity= (MainActivity) getActivity();
        initData();
        initBase();
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 初始化下拉刷新及滚动距离title发生的改变
     */
    private void initBase() {
        homerecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                distanceY += dy;
                if (distanceY > ScreenUtil.dip2px(mActivity, 20)) {
                    homeTitleBarBgView.setBackgroundColor(getResources().getColor(R.color.white));
                    if (Build.VERSION.SDK_INT > 10) {
                        homeTitleBarBgView.setAlpha(distanceY * 1.0f / ScreenUtil.dip2px(mActivity, 100));
                    }
                    else {
                        DISTANCE_WHEN_TO_SELECTED = 20;
                    }
                }
                else {
                    homeTitleBarBgView.setBackgroundColor(0);
                }

                if (distanceY > ScreenUtil.dip2px(mActivity, DISTANCE_WHEN_TO_SELECTED) && !scanningLayout.isSelected()) {
                    scanningLayout.setSelected(true);
                    advisoryLayout.setSelected(true);
                }
                else if (distanceY <= ScreenUtil.dip2px(mActivity, DISTANCE_WHEN_TO_SELECTED) && scanningLayout.isSelected()) {
                    scanningLayout.setSelected(false);
                    advisoryLayout.setSelected(false);
                }
            }
        });
       /* homerecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                switch (newState){
                    //滑动停止
                    case RecyclerView.SCROLL_STATE_IDLE:

                        break;
                    //手指触摸屏幕停止或拖动时
                    case RecyclerView.SCROLL_STATE_DRAGGING:

                        break;
                    //滑动且手指离开屏幕
                    case RecyclerView.SCROLL_STATE_SETTLING:

                        break;
                }

            }
        });*/

        /*recyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int velocityX, int velocityY) {
                if(Math.abs(velocityY) > 5000){

                }
                return false;
            }
        });*/
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initData() {
        homerecyclerView = rootView.findViewById(R.id.homerecycler);
        context = GlobalAppComponent.getAppComponent().getContext();
        mDataManager = GlobalAppComponent.getAppComponent().getDataManager();
        refreshLayout = (RefreshLayout) rootView.findViewById(R.id.refreshLayout);
        mNonetView = (View) rootView.findViewById(R.id.carrecycle_nonet);//无网络布局
        homerecyclerView.addItemDecoration(new RecommenderItemDecoration(context));
        setSmartRecyclerRefreshAndLoadMore();
        if (NetworkUtil.isNetworkAvailable(context)){
            getHomeBannerImgAndBargainGoods(false);
        }
        homeAdapter = new MyHomeAdapter(context);
        onRecommendWaresItemClick();
    }
    //获取特价商品和轮播图
    private void getHomeBannerImgAndBargainGoods(boolean update) {
        activity.showProgressDialogView();
        mDataManager.getHomeBannerImgAndBargainGoods(new ErrorDisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                if (logswitch) {
                    Log.d("yuan", "HomePresenter---getHomeBannerImgAndBargainGoods: onNext（）方法:" + homeWares.getCode());
                    Log.d("yuan", "HomePresenter---getHomeBannerImgAndBargainGoods:onNext（）方法,商品名称是"
                            + homeWares.getItems().get(0).getItemList().toString());

                }
                for(int i=0;i<homeWares.getItems().get(1).getItemList().size();i++)
                {
                    Log.d("yuan",homeWares.getItems().get(1).getItemList().get(i).getGoodsName());
                }
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode())) {
                    if (homeWares.getItems().get(0).getItemType().equals("topBanner")) {
                        homeAdapter.setHomeBannerImgAndBargainGoods(homeWares.getItems().get(0).getItemList());
                    }
                    if (homeWares.getItems().get(1).getItemType().equals("goods")) {
                        Log.d("yuan", "设置goods数据");
                        homeAdapter.setBargainGoods(homeWares.getItems().get(1).getItemList());
                    }
                }
            }

            //如果需要发生Error时操作UI可以重写onError，统一错误操作可以在ErrorDisposableObserver中统一执行
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Toast.makeText(activity, "获取数据失败", Toast.LENGTH_SHORT).show();
                if (logswitch)
                    Log.d("yuan", "HomePresenter---getHomeBannerImgAndBargainGoods错误: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                getRecommendedWares(false);
                activity.hiddenProgressDialogView();
                if (logswitch)
                    Log.d("yuan", "HomePresenter---getHomeBannerImgAndBargainGoods到了onComplete（）方法");
            }
        }, update);
    }

    private void getMoreRecommendedWares(boolean update)
    {
        pageindextemp=pageindex;
        pageindextemp++;
        getRecommendedWares(update);
    }
    private void   getUpdateRecommendedWares(boolean update)
    {
        pageindextemp=1;
        getRecommendedWares(update);
    }
    public void getRecommendedWares(boolean update) {
        mDataManager.getHomeWares(new ErrorDisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                if (logswitch) {
                    Log.d("yuan", "HomePresenter---getRecommendedWares: onNext（）方法" + homeWares.getItems().get(0).getItemList().size());
                    Log.d("yuan", "HomePresenter---getRecommendedWares:onNext（）方法,商品名称是"
                            + homeWares.getItems().get(0).getItemList().get(0).getGoodsName());
                }
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode()) && homeWares.getPageindex() == 1) {
                    setRecommendedWares(homeWares.getItems().get(0).getItemList());
                    pageindex=homeWares.getPageindex();
                }
                if (CommonConfig.SUCCESS_CODE.equals(homeWares.getCode())&&homeWares.getPageindex()>1) {
                    if (homeWares.getIsOver().equals(CommonConfig.HAVE_NEXT_PAGE)||homeWares.getIsOver().equals(CommonConfig.LAST_PAGE)) {
                        setMoreRecommendedWares(homeWares.getItems().get(0).getItemList());
                    }else {
                        Toast.makeText(activity, "没有更多数据了", Toast.LENGTH_SHORT).show();
                    }
                    pageindex=homeWares.getPageindex();
                }
            }
            @Override
            public void onError(Throwable e) {
                if (logswitch)
                    Log.d("yuan", "HomePresenter---getRecommendedWares错误: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadmore();
                if (logswitch)
                    Log.d("yuan", "HomePresenter---getRecommendedWares: 到了onComplete（）方法");
            }
        },pageindextemp,update);
        Log.d("yuan", "getMoreRecommendedWares:访问页码是="+pageindextemp);
    }

    private void setRecommendedWares(List<HomeWares.ItemsBean.ItemListBean> itemList) {
        homeAdapter.setRecommendWares(itemList);
        GridLayoutManager manager = new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position>1) {
                    return 1;
                }else return 2;
            }
        });
        homerecyclerView.setHasFixedSize(true);
        homerecyclerView.setLayoutManager(manager);
        homerecyclerView.setAdapter(homeAdapter);
    }

    private void setMoreRecommendedWares(List<HomeWares.ItemsBean.ItemListBean> itemList) {
        homeAdapter.addData(itemList);
    }

    private void setSmartRecyclerRefreshAndLoadMore() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isConnectNet();
                getUpdateRecommendedWares(true);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isConnectNet();
                getMoreRecommendedWares(false);
            }
        });
    }

    public void onPositionChange(int currentPosY) {
        if (currentPosY > 0) {
            if (homeTitleBarLayout.getVisibility() == View.VISIBLE) {
                homeTitleBarLayout.setVisibility(View.GONE);
            }
        } else {
            if (homeTitleBarLayout.getVisibility() == View.GONE) {
                homeTitleBarLayout.setVisibility(View.VISIBLE);
                distanceY = 0;
            }
        }
    }
    private void onRecommendWaresItemClick(){
        homeAdapter.setOnItemClickListener(new MyHomeAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view , int position){
                Toast.makeText(activity, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
    //网络连接与否
    private void isConnectNet() {

        if (!NetworkUtil.isNetworkAvailable(context)) {
            mNonetView.setVisibility(View.VISIBLE);
            mEmtryView.setVisibility(View.GONE);
            mItemView.setVisibility(View.GONE);
        }
        else {
            //从服务器获取数据
            initData();
        }

    }

}
