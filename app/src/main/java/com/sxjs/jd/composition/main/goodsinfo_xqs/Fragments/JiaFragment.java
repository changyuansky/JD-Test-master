package com.sxjs.jd.composition.main.goodsinfo_xqs.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.sxjs.common.base.BaseFragment;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.goodsinfo_xqs.ViewColorUtils.ViewColorUtils;

//import static com.example.administrator.qsjingdong.ViewColorUtils.ViewColorUtils.setViewColor;

/**
 * Created by Administrator on 2017/7/15.
 */

public class JiaFragment extends BaseFragment implements View.OnClickListener{
    //评价
    View view;
    TextView        textView_all,textView_all_number,textView_hao,textView_hao_number,
                    textView_cha,textView_cha_number,textView_zhong,textView_zhong_number,
                    textView_youtu,textView_youtu_number;

    LinearLayout    layout_all,layout_hao,layout_cha,layout_zhong,layout_youtu;
    boolean all_status=false,hao_status=false,cha_status=false,zhong_status=false,youtu_status=false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.jia_fragment,null);
        initView();

        layout_all.setOnClickListener(this);
        layout_hao.setOnClickListener(this);
        layout_cha.setOnClickListener(this);
        layout_zhong.setOnClickListener(this);
        layout_youtu.setOnClickListener(this);
        return view;
    }
    public void initView()
    {
        textView_all_number=view.findViewById(R.id.text_all_ping_number);
        textView_hao_number=view.findViewById(R.id.text_hao_ping_number);
        textView_zhong_number=view.findViewById(R.id.text_zhong_ping_number);
        textView_cha_number=view.findViewById(R.id.text_cha_ping_number);
        textView_youtu_number=view.findViewById(R.id.text_youtu_ping_number);
        textView_all=view.findViewById(R.id.text_all_ping);
        textView_hao=view.findViewById(R.id.text_hao_ping);
        textView_zhong=view.findViewById(R.id.text_zhong_ping);
        textView_cha=view.findViewById(R.id.text_cha_ping);
        textView_youtu=view.findViewById(R.id.text_youtu_ping);
        layout_all=view.findViewById(R.id.layout_all_ping);
        layout_hao=view.findViewById(R.id.layout_hao_ping);
        layout_zhong=view.findViewById(R.id.layout_zhong_ping);
        layout_cha=view.findViewById(R.id.layout_cha_ping);
        layout_youtu=view.findViewById(R.id.layout_youtu_ping);
        Log.d("123","初始化成功");
        LayoutisPressed(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.layout_all_ping:
            {
                LayoutisPressed(0);
                break;
            }
            case R.id.layout_hao_ping:
            {
                LayoutisPressed(1);
                break;
            }
            case R.id.layout_zhong_ping:
            {

                LayoutisPressed(2);
                break;
            }
            case R.id.layout_cha_ping:
            {
                LayoutisPressed(3);
                break;
            }
            case R.id.layout_youtu_ping:
            {
                LayoutisPressed(4);
                break;
            }
        }
    }

    //有图字体
    public void setSelectortextColor()
    {
        Log.d("set","Youtu"+youtu_status);
        Log.d("set","hao_status"+hao_status);
        Log.d("set","cha_status"+cha_status);
        Log.d("set","zhong_status"+zhong_status);
        Log.d("set","all_status"+all_status);
        ViewColorUtils.setViewColor(textView_all,"#000000");
        ViewColorUtils.setViewColor(textView_all_number,"#000000");

        ViewColorUtils.setViewColor(textView_hao,"#000000");
        ViewColorUtils.setViewColor(textView_hao_number,"#000000");

        ViewColorUtils.setViewColor(textView_cha,"#000000");
        ViewColorUtils.setViewColor(textView_cha_number,"#000000");

        ViewColorUtils.setViewColor(textView_zhong,"#000000");
        ViewColorUtils.setViewColor(textView_zhong_number,"#000000");

        ViewColorUtils.setViewColor(textView_youtu,"#000000");
        ViewColorUtils.setViewColor(textView_youtu_number,"#000000");

        if (all_status)
        {
            ViewColorUtils.setViewColor(textView_all,"#AAC90404");
            ViewColorUtils.setViewColor(textView_all_number,"#AAC90404");
        }
        else if (zhong_status)
        {
            ViewColorUtils.setViewColor(textView_zhong,"#AAC90404");
            ViewColorUtils.setViewColor(textView_zhong_number,"#AAC90404");
        }
        else if (cha_status)
        {
            ViewColorUtils.setViewColor(textView_cha,"#AAC90404");
            ViewColorUtils.setViewColor(textView_cha_number,"#AAC90404");
        }
        else if (hao_status)
        {
            ViewColorUtils.setViewColor(textView_hao,"#AAC90404");
            ViewColorUtils.setViewColor(textView_hao_number,"#AAC90404");
        }
        else if (youtu_status)
        {
            ViewColorUtils.setViewColor(textView_youtu,"#AAC90404");
            ViewColorUtils.setViewColor(textView_youtu_number,"#AAC90404");
        }
    }
    public void LayoutisPressed(int i)
    {
        all_status=false;hao_status=false;cha_status=false;zhong_status=false;youtu_status=false;
        switch (i)
        {
            case 0:
            {
                all_status=true;
                break;
            }
            case 1:
            {
                hao_status=true;
                break;
            }
            case 2:
            {
                zhong_status=true;
                break;
            }
            case 3:
            {
                cha_status=true;
                break;
            }
            case 4:
            {
                youtu_status=true;
                break;
            }
        }
        setSelectortextColor();

    }

}
