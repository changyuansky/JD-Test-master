package com.sxjs.common.model.http;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.sxjs.common.CommonConfig;
import com.sxjs.common.cache.CacheProvider;
import com.sxjs.common.parser.GsonTSpeaker;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.rx_cache2.internal.RxCache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * http helper负责创建ApiService实例
 */
@Singleton
public class HttpHelper {
    private Context context;
    private Retrofit mRetrofitClient;
    private HashMap<String, BaseApiService> mServiceMap;
    private CacheProvider cacheProvider;

    @Inject
    public HttpHelper(Context context) {
        this.context = context;
        mServiceMap = new HashMap<>();
        initRetrofitClient();
        initRxCache();
    }


    @SuppressWarnings("unchecked")
    public BaseApiService getService(Class<BaseApiService> serviceClass) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return  mServiceMap.get(serviceClass.getName());
        } else {
            BaseApiService baseApiService = createService(serviceClass, null);
            mServiceMap.put(serviceClass.getName(), baseApiService);
            return  baseApiService;
        }


    }

    @SuppressWarnings("unchecked")
    public BaseApiService getService(Class<BaseApiService> serviceClass, OkHttpClient client) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return  mServiceMap.get(serviceClass.getName());
        } else {
            BaseApiService baseApiService = createService(serviceClass, client);
            mServiceMap.put(serviceClass.getName(), baseApiService);
            return  baseApiService;
        }
    }

    private void initRetrofitClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(CommonConfig.HTTP_READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CommonConfig.HTTP_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new BaseInterceptor<>(null,context))
                .build();
        mRetrofitClient = createRetrofitClient(httpClient);
        if (httpClient.readTimeoutMillis()/1000>CommonConfig.HTTP_READ_TIME_OUT){
            Toast.makeText(context, "读取数据超时", Toast.LENGTH_SHORT).show();
        }
        if (httpClient.connectTimeoutMillis()/1000>CommonConfig.HTTP_READ_TIME_OUT){
            Toast.makeText(context, "连接超时", Toast.LENGTH_SHORT).show();
        }
    }

    private Retrofit createRetrofitClient(OkHttpClient httpClient) {

        return new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(CommonConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    private BaseApiService createService(Class<BaseApiService> serviceClass, OkHttpClient client){
        if(client == null){
            return mRetrofitClient.create(serviceClass);
        }else{
            return createRetrofitClient(client).create(serviceClass);
        }
    }
public void initRxCache(){
    cacheProvider = new RxCache.Builder()
            .persistence(context.getFilesDir(), new GsonTSpeaker())
            .using(CacheProvider.class);
    }

    public CacheProvider getCacheProvider(){
        return cacheProvider;
    }

}
