package com.sxjs.jd.composition.main.classifyicon_zy;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils.MyAdapter;
import com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils.MyDecoration;
import com.sxjs.jd.composition.main.classifyicon_zy.RecyclerviewUtils.MyOnScrollListener;
import com.sxjs.jd.composition.main.classifyicon_zy.SwipeRefreshLayoutUtils.MyOnRefreshListener;
import com.sxjs.jd.composition.main.classifyicon_zy.TablayoutUtils.MyOnTabSelectedListener;
import com.zhy.autolayout.config.AutoLayoutConifg;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.observers.DisposableObserver;
@Route(path = "/iconlist/classifyiconactivity_zy")
public class ClassifyIconActivity extends AppCompatActivity {

    @BindView(R.id.scanning_img)
    ImageView scanningImg;
    @BindView(R.id.advisory_img)
    ImageView advisoryImg;
    @BindView(R.id.tablayout_main)
    TabLayout tablayoutMain;
    @BindView(R.id.recyclertview_main)
    RecyclerView recyclertviewMain;
    @BindView(R.id.swiperefreshlayout_main)
    SwipeRefreshLayout swiperefreshlayoutMain;

    private String TAG  = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.classifyicon_activity_layout);
        ButterKnife.bind(this);
        AutoLayoutConifg.getInstance().useDeviceSize();


        Log.d(TAG, "onCreate: 进入主页");


        GlobalAppComponent.getAppComponent().getDataManager().getCatGoodsInfoByCatIdAndPageindex(new DisposableObserver<HomeWares>() {
            @Override
            public void onNext(HomeWares homeWares) {
                if (homeWares != null){
                    Log.d(TAG, "onNext: 拿到数据了"+homeWares.toString());

                    MyAdapter myAdapter = new MyAdapter(ClassifyIconActivity.this,homeWares.getItems().get(0).getItemList());
                    recyclertviewMain.setAdapter(myAdapter);
                    recyclertviewMain.setLayoutManager(new GridLayoutManager(ClassifyIconActivity.this,1));
                    recyclertviewMain.addItemDecoration(new MyDecoration(ClassifyIconActivity.this));
                    //添加滚动加载更多
                    recyclertviewMain.addOnScrollListener(new MyOnScrollListener(ClassifyIconActivity.this,myAdapter));

                }else {
                    Toast.makeText(ClassifyIconActivity.this,"请检查网络设置",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, 14, 1, false);

        swiperefreshlayoutMain.setOnRefreshListener(new MyOnRefreshListener(swiperefreshlayoutMain));

        tablayoutMain.addOnTabSelectedListener(new MyOnTabSelectedListener(recyclertviewMain));

    }


}
