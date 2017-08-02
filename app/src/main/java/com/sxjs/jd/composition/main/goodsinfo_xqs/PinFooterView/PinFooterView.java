package com.sxjs.jd.composition.main.goodsinfo_xqs.PinFooterView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sxjs.jd.R;


/**
 * Created by Administrator on 2017/7/16.
 */

public class PinFooterView extends LinearLayout{
    String name="http://schemas.android.com/apk/res/android";
    TextView textView1;
    TextView textView2;
    Button button;
    public PinFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PinFooterView(Context context) {
        super(context);
    }

    public PinFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void init()
    {
        View.inflate(getContext(), R.layout.pin_view_item,this);
        textView1=findViewById(R.id.text_pin_view_1);
        textView2=findViewById(R.id.text_pin_view_2);
        button=findViewById(R.id.btn_pin_view);

    }
    public void setTextView1(String text1)
    {
        textView1.setText(text1);
    }
    public void setTextView2(String text)
    {
        textView2.setText(text);
    }

}
