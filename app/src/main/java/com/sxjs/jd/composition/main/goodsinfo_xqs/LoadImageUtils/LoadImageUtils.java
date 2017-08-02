package com.sxjs.jd.composition.main.goodsinfo_xqs.LoadImageUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/7/22.
 */

public class LoadImageUtils {
    Bitmap bitmap;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    public  Bitmap getBitmap(final String path) throws IOException {
        new Thread(){
            @Override
            public void run() {
                super.run();
                URL url = null;
                try {
                    url = new URL(path);
                    HttpURLConnection conn = null;
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("GET");
                    if (conn.getResponseCode() ==200)
                    {
                        InputStream inputStream=conn.getInputStream();
                        Bitmap mbitmap=BitmapFactory.decodeStream(inputStream);
                        Message message=new Message();
                        message.what=1;
                        message.obj=message;
                        handler.sendMessage(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    return null;
    }
}
