package com.sxjs.jd.composition.main.goodsinfo_xqs.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sxjs.common.base.BaseFragment;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.goodsinfo_xqs.XiangqingFragment.GuigeFragment;
import com.sxjs.jd.composition.main.goodsinfo_xqs.XiangqingFragment.JieshaoFragment;
import com.sxjs.jd.composition.main.goodsinfo_xqs.XiangqingFragment.ShouhouFragment;

/**
 * Created by Administrator on 2017/7/15.
 */

public class QingFragment extends BaseFragment {
    //图片详情
//    View view;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view=inflater.inflate(R.layout.qing_fragment,null);
//        return view;
//    }
private static final String TAG = "HomeFragment";
    private View mView;
    private GestureDetector mGestureDetector;
    private int verticalMinistance = 100;            //水平最小识别距离
    private int minVelocity = 10;            //最小识别速度
    private void initViews() {
        mGestureDetector = new GestureDetector(getActivity(), new LearnGestureListener());
        //为fragment添加OnTouchListener监听器
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mGestureDetector.onTouchEvent(event);
            }
        });
    }
    /*******************************************/
    //初始化属性
    Button textjieshao;
    Button textguige;
    Button textshouhou;
    private boolean jieshao_status=true;
    private boolean guige_status=false;
    private boolean shouhou_status=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.qing_fragment, null);

        textguige=mView.findViewById(R.id.text_qing_guige);
        textjieshao=mView.findViewById(R.id.text_qing_jieshao);
        textshouhou=mView.findViewById(R.id.text_qing_shouhou);
        textstatus();
        textjieshao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jieshao_status=true;
                guige_status=false;
                shouhou_status=false;
                textstatus();
            }
        });
        textguige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jieshao_status=false;
                guige_status=true;
                shouhou_status=false;
                textstatus();

            }
        });
        textshouhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jieshao_status=false;
                guige_status=false;
                shouhou_status=true;
                Log.d("3","3");
                textstatus();
            }
        });
        return mView;
    }
    //设置手势识别监听器
    public class LearnGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getRawX() - e2.getRawX() > verticalMinistance && Math.abs(velocityX) > minVelocity) {
                showToast("left");
                getFragmentManager().popBackStack();
            } else if (e2.getX() - e1.getX() > verticalMinistance && Math.abs(velocityX) > minVelocity) {
                showToast("right");
            }
            return false;
        }

        //此方法必须重写且返回真，否则onFling不起效
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }
    public void showToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }
//    public void textstatus()
//    {
//        if (jieshao_status==true&&guige_status==false&&shouhou_status==false)
//        {
//            //将Fragment加载到Activity布局中
//            JieshaoFragment fragment=new JieshaoFragment();
//            addFragment(fragment);
//        }
//        else if (jieshao_status==false&&guige_status==true&&shouhou_status==false)
//        {
//
//            GuigeFragment fragment=new GuigeFragment();
//            addFragment(fragment);
//        }
//        else if (jieshao_status==false&&guige_status==false&&shouhou_status==true)
//        {
//
//            ShouhouFragment fragment=new ShouhouFragment();
//            addFragment(fragment);
//        }
//    }
//    public void addFragment(Fragment fragment)
//    {
//        //获取FragmentManager 实例
//        FragmentManager fm=getFragmentManager();
//        //获取FragmentTransaction 实例
//        FragmentTransaction begin=fm.beginTransaction();
//        //添加fragment
//        begin.replace(R.id.Qing_fragment,fragment).commit();
//    }
public void textstatus()
{
    if (jieshao_status==true&&guige_status==false&&shouhou_status==false)
    {
        textjieshao.setTextColor(Color.parseColor("#AAC90404"));
        textguige.setTextColor(Color.parseColor("#AA000000"));
        textshouhou.setTextColor(Color.parseColor("#AA000000"));
        //将Fragment加载到Activity布局中
        JieshaoFragment fragment=new JieshaoFragment();
        addFragment(fragment);
    }
    else if (jieshao_status==false&&guige_status==true&&shouhou_status==false)
    {

        textjieshao.setTextColor(Color.parseColor("#AA000000"));
        textguige.setTextColor(Color.parseColor("#AAC90404"));
        textshouhou.setTextColor(Color.parseColor("#AA000000"));
        GuigeFragment fragment=new GuigeFragment();
        addFragment(fragment);
    }
    else if (jieshao_status==false&&guige_status==false&&shouhou_status==true)
    {

        textjieshao.setTextColor(Color.parseColor("#AA000000"));
        textguige.setTextColor(Color.parseColor("#AA000000"));
        textshouhou.setTextColor(Color.parseColor("#AAC90404"));
        ShouhouFragment fragment=new ShouhouFragment();
        addFragment(fragment);
    }
}
    public void addFragment(Fragment fragment)
    {
        //获取FragmentManager 实例
        FragmentManager fm=getFragmentManager();
        //获取FragmentTransaction 实例
        FragmentTransaction begin=fm.beginTransaction();
        //添加fragment
        begin.replace(R.id.Qing_fragment,fragment).commit();
    }
}
