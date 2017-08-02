package com.sxjs.jd.composition.main.goodsinfo_xqs.ViewColorUtils;

import android.graphics.Color;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/7/18.
 */

public class ViewColorUtils {
    public static void setViewColor(TextView textView, String color)
    {
        textView.setTextColor(Color.parseColor(color));
    }
}
