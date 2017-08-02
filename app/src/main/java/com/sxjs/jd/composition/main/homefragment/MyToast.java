package com.sxjs.jd.composition.main.homefragment;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MyToast extends Toast{
    private Context context;
    public MyToast(Context context) {
        super(context);
        this.context= context;
    }
    public void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
