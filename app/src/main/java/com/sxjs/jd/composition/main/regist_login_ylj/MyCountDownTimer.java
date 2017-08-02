package com.sxjs.jd.composition.main.regist_login_ylj;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class MyCountDownTimer extends CountDownTimer{
    Button button;
    public MyCountDownTimer(Button button,long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.button=button;
    }

    @Override
    public void onTick(long l) {
        button.setClickable(false);
        button.setText(l/1000+"秒后可重新发送");
        button.setBackgroundColor(Color.parseColor("#B6B6D8"));
    }

    @Override
    public void onFinish() {
        button.setText("重新获取验证码");
        button.setClickable(true);
        button.setBackgroundColor(Color.parseColor("4EB84A"));
    }
}
