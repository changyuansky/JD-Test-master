package com.sxjs.jd.composition.main.goodsinfo_xqs;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.model.DataManager;
import com.sxjs.common.model.dao.DataBaseHelper;
import com.sxjs.common.model.http.HttpHelper;
import com.sxjs.common.model.sp.SharePreferenceHelper;

/**
 * @author admin
 */
public class MyApplication extends Application {

    HttpHelper httpHelper;
    SharePreferenceHelper sharePreferenceHelper;
    DataBaseHelper dataBaseHelper;
    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        if(CommonConfig.DEBUG){
//            LeakCanary.install(this);
//            ARouter.openLog();     // 打印日志
//            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }

        ARouter.init(this);
        //CrashReport.initCrashReport(getApplicationContext(), "93f0e37549", CommonConfig.DEBUG);
        Fresco.initialize(this);
        GlobalAppComponent.init(this);
        httpHelper= new HttpHelper(this);
        sharePreferenceHelper = new SharePreferenceHelper(this);
        dataBaseHelper = new DataBaseHelper(this);
        dataManager = new DataManager(this,httpHelper,sharePreferenceHelper,dataBaseHelper);
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        imagePipeline.clearMemoryCaches();
    }


    public DataManager getDataManager(){
        return dataManager;
    }

    public HttpHelper getHttpHelper(){
        return httpHelper;
    }
    public SharePreferenceHelper getSharePreferenceHelper(){
        return sharePreferenceHelper;
    }
    public DataBaseHelper getDataBaseHelper(){
        return dataBaseHelper;
    }
}
