package com.sxjs.jd.composition.main.goodsinfo_xqs;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sxjs.common.CommonConfig;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.goodsinfo_xqs.Adapters.GridViewAdapter;
import com.sxjs.jd.composition.main.goodsinfo_xqs.Adapters.MyBaseAdapter;
import com.sxjs.jd.composition.main.goodsinfo_xqs.Adapters.MyPagerViewAdapter;
import com.sxjs.jd.composition.main.goodsinfo_xqs.DividerItemDecoration.DividerItemDecoration;
import com.sxjs.jd.composition.main.goodsinfo_xqs.Fragments.JiaFragment;
import com.sxjs.jd.composition.main.goodsinfo_xqs.Fragments.PinFragment;
import com.sxjs.jd.composition.main.goodsinfo_xqs.Fragments.QingFragment;
import com.sxjs.jd.composition.main.goodsinfo_xqs.RecyclerItemClickListener.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;
@Route(path = "/xqs/mainfragmentactivity")
public class MainFragmentActivity extends AppCompatActivity implements View.OnClickListener{
    List<String> titlelist;
    List<String> GridviewString;
    List<Fragment> fragmentList;
    ViewPager viewPager;
    Button btn_more,btn_share;
    List<String> morelist;
    RecyclerView recyclerView;
    PopupWindow popupWindow,popuWindow_share;
    int Type=0;
    private int default_goodsId=5;
    private PinFragment pinFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodsinfo);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.main_table);
        btn_more= (Button) findViewById(R.id.btn_xq_more);
        btn_share=(Button)findViewById(R.id.btn_xq_share);
        btn_more.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        viewPager= (ViewPager) findViewById(R.id.main_vp);

        inittitle();
        initfragment();
        getGoodsId();//获取goodsId
        initMore();
        initGridviewString();
        MyPagerViewAdapter adapter=new MyPagerViewAdapter(getSupportFragmentManager(),titlelist,fragmentList);
        for (int i=0;i<titlelist.size();i++)
        {
            tabLayout.addTab(tabLayout.newTab().setText(titlelist.get(i)));
        }
        viewPager.setAdapter(adapter);
        //// 设置TableLayout为可滚动（在ViewPager设置Adapter之后），也可在布局中添加tabMode属性
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        // 将TabLayout和ViewPager关联起来
        tabLayout.setupWithViewPager(viewPager);
        //// 给Tabs设置适配器
        tabLayout.setTabsFromPagerAdapter(adapter);
    }
    public void inittitle()
    {
        titlelist=new ArrayList<>();
        titlelist.add("商品");
        titlelist.add("详情");
        titlelist.add("评价");
    }
    //tableLayout+ViewPager+fragment
    public void initfragment()
    {
        pinFragment = new PinFragment();
        fragmentList=new ArrayList<>();
        fragmentList.add(pinFragment);
        fragmentList.add(new QingFragment());
        fragmentList.add(new JiaFragment());
    }
    public void initMore()
    {
        morelist=new ArrayList<>();
        morelist.add("消息");
        morelist.add("首页");
        morelist.add("搜索");
        morelist.add("我的关注");
        morelist.add("浏览记录");
    }
    public void initGridviewString()
    {
        GridviewString=new ArrayList<>();
        GridviewString.add("微信好友");
        GridviewString.add("朋友圈");
        GridviewString.add("QQ好友");
        GridviewString.add("QQ空间");
    }
    //获取由跳转得到的goodsId
    private void getGoodsId(){
        pinFragment.setGoodsId(getIntent().getIntExtra(CommonConfig.GOODSINFO_KEY,default_goodsId));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_xq_more:
            {

                if (popupWindow!=null&&popupWindow.isShowing())
                {
                    popupWindow.dismiss();
                }
                else {
                    showmorewindow(view);
                }
                break;
            }
            case R.id.btn_xq_share:
            {
                Toast.makeText(MainFragmentActivity.this,"2",Toast.LENGTH_SHORT).show();
                if (popuWindow_share!=null&&popuWindow_share.isShowing())
                {
                    popuWindow_share.dismiss();
                }
                else {
                    View contextview= LayoutInflater.from(MainFragmentActivity.this).inflate(R.layout.popuwindow_share_item,null);
                    GridView gridview=contextview.findViewById(R.id.gridview);
                    gridview.setAdapter(new GridViewAdapter(GridviewString,view.getContext()));
                    showWindow(contextview);
                    Button buttonShare=contextview.findViewById(R.id.btn_main_share);
                    buttonShare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {popuWindow_share.dismiss();
                        }
                    });
                    CheckBox checkShare=contextview.findViewById(R.id.ckeck_main_share);
                    checkShare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(view.getContext(),MainShareGuizeActivity.class);
                            startActivity(intent);
                            popuWindow_share.dismiss();
                        }
                    });
                }
                break;
            }
        }
    }
    public void showmorewindow(View view)
    {
        Toast.makeText(MainFragmentActivity.this,"1",Toast.LENGTH_SHORT).show();
        View contextview= LayoutInflater.from(MainFragmentActivity.this).inflate(R.layout.popuwindow_more_activity,null);
        popupWindow=new PopupWindow(contextview,200,ViewGroup.LayoutParams.WRAP_CONTENT);
        recyclerView=contextview.findViewById(R.id.popuwindow_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new MyBaseAdapter(view.getContext(),morelist));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,1));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(contextview.getContext(),recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position)
                {
                    case 0:
                    {
                        Log.d("more",""+position);
                        break;
                    }
                    case 1:
                    {
                        Log.d("more",""+position);
                        break;
                    }
                    case 2:
                    {
                        Log.d("more",""+position);
                        break;
                    }
                    case 3:
                    {
                        Log.d("more",""+position);
                        break;
                    }
                    case 4:
                    {
                        Log.d("more",""+position);
                        break;
                    }
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF302F2F")));
        popupWindow.setAnimationStyle(R.style.contextMenuAnim);
        // 需要设置一下此参数，点击外边可消失
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(btn_more,0,0);
    }
    public void showWindow(View contextview)
    {
        popuWindow_share=new PopupWindow(contextview);
        popuWindow_share.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF302F2F")));
        popuWindow_share.setAnimationStyle(R.style.Animation);
        popuWindow_share.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popuWindow_share.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 需要设置一下此参数，点击外边可消失
        popuWindow_share.setTouchable(true);
        popuWindow_share.setFocusable(true);
        popuWindow_share.setOutsideTouchable(true);
        popuWindow_share.showAtLocation(btn_more, Gravity.BOTTOM,0,0);
        //设置弹出后  屏幕的颜色
        WindowManager.LayoutParams lp=getWindow().getAttributes();
        lp.alpha=0.7f;
        getWindow().setAttributes(lp);
        popuWindow_share.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp=getWindow().getAttributes();
                lp.alpha=1f;
                getWindow().setAttributes(lp);
            }
        });

    }

}
