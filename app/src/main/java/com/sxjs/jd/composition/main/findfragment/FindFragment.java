package com.sxjs.jd.composition.main.findfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxjs.common.AppComponent;
import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.model.DataManager;
import com.sxjs.common.model.dao.DataBaseHelper;
import com.sxjs.common.model.http.HttpHelper;
import com.sxjs.common.model.http.HttpHelper_Factory;
import com.sxjs.common.model.sp.SharePreferenceHelper;
import com.sxjs.common.widget.headerview.JDHeaderView;
import com.sxjs.common.widget.pulltorefresh.PtrFrameLayout;
import com.sxjs.common.widget.pulltorefresh.PtrHandler;
import com.sxjs.jd.MyApplication;
import com.sxjs.jd.R;
import com.sxjs.common.base.BaseFragment;
import com.sxjs.jd.composition.entities.FindsBean;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Component;

/**
 * @author admin
 */
public class FindFragment extends BaseFragment implements PtrHandler, BaseQuickAdapter.RequestLoadMoreListener {

    FindPresenter mPresenter;
    @BindView(R.id.find_recyclerview)
    RecyclerView findRecyclerview;
    @BindView(R.id.find_pull_refresh_header)
    JDHeaderView findPullRefreshHeader;
    private FindsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;

    }

    public static FindFragment newInstance() {
        return new FindFragment();
    }

    public void initView() {
        mPresenter = new FindPresenter(getAppComponent().getDataManager(),this);
        findPullRefreshHeader.setPtrHandler(this);
        findRecyclerview.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new FindsAdapter(R.layout.item_finds_recyclerview);
        adapter.setOnLoadMoreListener(this);
        adapter.setEnableLoadMore(true);
        findRecyclerview.setAdapter(adapter);
    }

    public void initData() {
        mPresenter.getFindData();
    }


    private static final String TAG = "FindFragment";


    public void setFindData(FindsBean find) {
        //adapter.addData(find.content);
    }


    public void setMoreData(List<HomeWares.ItemsBean.ItemListBean> find) {
        adapter.getData().addAll(find);
        adapter.loadMoreComplete();

    }

    @Override
    public void onRefreshBegin(final PtrFrameLayout frame) {
        frame.postDelayed(new Runnable() {
            @Override
            public void run() {
                frame.refreshComplete();
            }
        }, 2000);

    }
    @Override
    public void onLoadMoreRequested() {
        findRecyclerview.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapter.getData().size() >= 90){
                    adapter.loadMoreEnd(false);
                }
                else{
                    Log.d("yuan", "发现->加载更多触发");
                    mPresenter.getMoreFindData();
                }
            }
        },1000);

    }
}
