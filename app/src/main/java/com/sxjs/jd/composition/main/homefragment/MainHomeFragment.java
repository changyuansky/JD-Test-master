package com.sxjs.jd.composition.main.homefragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.bean.HomeBannerImg;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.util.ScreenUtil;
import com.sxjs.common.widget.headerview.JDHeaderView;
import com.sxjs.common.widget.pulltorefresh.PtrFrameLayout;
import com.sxjs.common.widget.pulltorefresh.PtrHandler;
import com.sxjs.jd.R;
import com.sxjs.common.base.BaseFragment;
import com.sxjs.jd.composition.main.MainActivity;


import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 作者：admin on 2017/3/15 10:47.
 */
public class MainHomeFragment extends BaseFragment implements JDHeaderView.RefreshDistanceListener , PositionChangedListener, BaseQuickAdapter.RequestLoadMoreListener {
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
    private View rootView = null;
    private RecyclerView recyclerView;
    private JDHeaderView mPtrFrame;
    private HomeMultipleRecycleAdapter adapter;
    private int distanceY;
    private MainActivity activity;
    /**
     * 加载首页样式标记
     */
    private int flag = 1;


    HomePresenter mPresenter;

    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recycle, container, false);
        activity= (MainActivity) getActivity();
        initBase();
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 初始化下拉刷新及滚动距离title发生的改变
     */
    private void initBase() {

        mPresenter = new HomePresenter(getAppComponent().getDataManager(),this,activity);

        initPtrFrame();
        recyclerView = (RecyclerView) this.rootView.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(getContext(),3)));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
        adapter = new HomeMultipleRecycleAdapter();
        /*recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
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
        adapter.setOnLoadMoreListener(this);
        adapter.setEnableLoadMore(true);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        mPresenter.getHomeBannerImgAndBargainGoods(false);
        if (!adapter.getData().isEmpty())
            mPresenter.getRecommendedWares(false);
    }

    /**
     * 初始化下拉刷新
     */
    private void initPtrFrame() {
        mPtrFrame = (JDHeaderView) rootView.findViewById(R.id.rotate_header_list_view_frame);
        mPtrFrame.setOnRefreshDistanceListener(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                updateData();
                mPtrFrame.autoRefresh();
            }
        });

        // 是否进入页面就开始显示刷新动作
        /*mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);*/
    }

    /**
     * 下拉后刷新数据
     */
    private void updateData() {
        //网络状态发生改变后，下拉刷新失效，及其恢复网络是的自动刷新访问等
        //放置一个计时器
        mPresenter.getRecommendedWares(true);
        Log.d("yuan", "下拉刷新触发");
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
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

    boolean logSwitch=false;

    //给特价商品设置数据
    public void setHomeBannerImgAndBargainGoods(HomeWares hBi_Bg) {
        adapter.getData().clear();
        adapter.addData(hBi_Bg.getItems());
        adapter.loadMoreComplete();
        Log.d("yuan", "setBargainGoods: 添加推荐商品数据集合");
    }

    //这个方法是  初次 RecommendedWares 给设置数据
    public void setRecommendedWares(HomeWares recommendedProducts) {
        if(recommendedProducts == null){
            //设置空布局
            adapter.setEmptyView(R.layout.empty);
            mPtrFrame.refreshComplete();
            return;
        }
        adapter.getData().clear();
        mPresenter.getHomeBannerImgAndBargainGoods(false);
        adapter.resetMaxHasLoadPosition();
        adapter.getData().addAll(recommendedProducts.getItems());
        mPtrFrame.refreshComplete();
    }

    //这个方法是   加载更多  时给mainRecyclerview设置数据
    public void setMoreRecommendedWares(HomeWares moreRecommendedProducts) {
        if (moreRecommendedProducts.getCode().equals("200")) {
            adapter.getData().addAll(moreRecommendedProducts.getItems());
            adapter.loadMoreComplete();
        }else if (moreRecommendedProducts.getCode().equals("-2")){
            adapter.loadMoreEnd();
            Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
        }
    }

    int currentPosition;
    /**
     * 当前recyclerView 的position的回调
     * @param position
     */
    @Override
    public void currentPosition(int position) {
        currentPosition=position;
        Log.d("yuan", "当前位置是："+position);
    }

    @Override
    public void onLoadMoreRequested() {
//        if (currentPosition==adapter.getItemCount()) {
//            Log.d("yuan", "onLoadMoreRequested:加载更多触发");
//            mPresenter.getMoreRecommendedWares(currentPosition / 10 + 1, false);
//        }
        if (adapter.getData().size() >= 240){
            adapter.loadMoreEnd(false);
        }
        else{
            mPresenter.getMoreRecommendedWares(currentPosition/10+1,false);
            Log.d("yuan", "onLoadMoreRequested:加载更多触发");
        }
    }


}
