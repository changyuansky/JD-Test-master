/*
 *    Copyright (C) 2016 Tamic
 *
 *    link :https://github.com/Tamicer/Novate
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.sxjs.common.model.http;


import com.sxjs.common.bean.BargainGoods;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.common.bean.HomeBannerImg;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.common.bean.ShopCar;
import com.sxjs.common.bean.UserInfo;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * ApiService
 * Created by Tamic on 2016-06-03.
 */
public interface BaseApiService {

    //1 获得主页最下方推荐商品(有缓存)
    @GET("GoodsServlet")
    Observable<HomeWares> getHomeWares(@Query("pageindex") int pageindex);

    //2 servlet/AdServlet   获取首页轮播图(有缓存)
    @GET("AdServlet")
    Observable<HomeBannerImg> getHomeBannerImg();

    //3 获取分类(有缓存)http://49.122.47.185:8080/XJD/api/CategoryServlet
    @GET("CategoryServlet")
    Observable<ClassFication> getClassFication();

    //4 根据分类catId 请求相应产品的详细信息(有缓存)
    @GET("CatGoodsServlet")
    Observable<HomeWares> getClassMoreInfo(@Query("catId") int catId);

    //5 用户注册,并返回用户详细信息(无缓存)
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("RegistServlet")
    Observable<UserInfo> postRegistUserInfo(@Body RequestBody Body);

    //6 获得特价商品(有缓存)
    @GET("GoodsIndexServlet")
    Observable<HomeWares> getBargainGoods();

    //7 登录，并返回用户信息 (无缓存)LoginServlet
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("LoginServlet")
    Observable<UserInfo> postLoginUserInfo(@Body RequestBody Body);

    //8 根据  手机号， 获取验证码 (无缓存)  http://49.122.47.185:8080/XJD/api/VCodeServlet
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("VCodeServlet")
    Observable<String> getVcode(@Query("phoneNumber") String mobilePhoneNumber);

    //9 购物车 (有缓存)  http://49.122.47.185:8080/XJD/api/ShopCarServlet?userId=7
    @GET("ShopCarServlet")
    Observable<ShopCar> getShopCarInfo(@Query("userId") int userId);

    //10 商品详情(无缓存)   http://49.122.47.185:8080/XJD/api/GoodsInfoServlet?goodsId=5
    @GET("GoodsInfoServlet")
    Observable<HomeWares> getGoodsInfo(@Query("userId") int goodsId);

    //11 订单详情(无缓存)   http://49.122.47.185:8080/XJD/api/OrderInfoServlet?userId=7
    @GET("OrderInfoServlet")
    Observable<MyOrderInfo> getOrderInfo(@Query("userId") int userId);
}


