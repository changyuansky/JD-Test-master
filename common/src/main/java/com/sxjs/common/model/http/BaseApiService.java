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


import com.sxjs.common.bean.Address;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.common.bean.OrdergoodsInfo;
import com.sxjs.common.bean.ShopCar;
import com.sxjs.common.bean.UserInfo;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * ApiService
 * Created by Tamic on 2016-06-03.
 */
public interface BaseApiService {

    //1 获得主页最下方推荐商品(有缓存)
    @GET("GoodsServlet")
    Observable<HomeWares> getHomeWares(@Query("pageindex") int pageindex);

    //2.  获取首页轮播图和特价商品(有缓存) http://192.168.1.177:8080/XJD/api/AdServlet
    @GET("AdServlet")
    Observable<HomeWares> getHomeBannerImgAndBargainGoods();

    //3 获取分类(有缓存)http://49.122.47.185:8080/XJD/api/CategoryServlet
    @GET("CategoryServlet")
    Observable<ClassFication> getClassFication();

    //4.   根据分类catId  pageindex请求相应产品的 详细信息+分页(有缓存)
    // http://49.122.47.185:8080/XJD/api/CatGoodsServlet?catId=14&pageindex=2
    @GET("CatGoodsServlet")
    Observable<HomeWares> getCatGoodsInfoByCatIdAndPageindex(@Query("catId") int catId,@Query("pageindex") int pageindex);

    //5 用户注册,并返回用户详细信息(无缓存)
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("RegistServlet")
    Observable<UserInfo> postRegistUserInfo(@Body RequestBody Body);

    //6 获得特价商品(有缓存)
//    @GET("GoodsIndexServlet")
//    Observable<HomeWares> getBargainGoods();

    //7 登录，并返回用户信息 (无缓存)LoginServlet
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("LoginServlet")
    Observable<UserInfo> postLoginUserInfo(@Body RequestBody Body);

    //8 根据  手机号， 获取验证码 (无缓存)  http://49.122.47.185:8080/XJD/api/VCodeServlet
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("VCodeServlet")
    Observable<String> getVcode(@Body RequestBody  mobilePhone);

    //9   购物车+分页 (有缓存)  http://49.122.47.185:8080/XJD/api/ShopCarServlet?userId=7&pageindex=1
    @GET("ShopCarServlet")
    Observable<ShopCar> getShopCarInfoByuserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);

    //10 商品详情(有缓存)   http://49.122.47.185:8080/XJD/api/GoodsInfoServlet?goodsId=5
    @GET("GoodsInfoServlet")
    Observable<HomeWares> getGoodsInfoBygoodsId(@Query("goodsId") int goodsId);

    //11   全部订单+分页(有缓存)   http://49.122.47.185:8080/XJD/api/OrderInfoServlet?userId=7&pageindex=1
    @GET("OrderInfoServlet")
    Observable<MyOrderInfo> getOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);

    //12   未付款订单(有缓存)  http://49.122.47.185:8080/XJD/api/PayNoOrderServlet?userId=7&pageindex=1
    @GET("PayNoOrderServlet")
    Observable<MyOrderInfo> getNoPayOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);
    // 13 . 待发货 http://49.122.47.185:8080/XJD/api/ShipNoOrderServlet?userId=7&pageindex=1
    @GET("ShipNoOrderServlet")
    Observable<MyOrderInfo> getShipNoOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);
    //14 . .已完成(有缓存)  http://49.122.47.185:8080/XJD/api/ShipNoOrderServlet?userId=7&pageindex=1
    @GET("ShipNoOrderServlet")
    Observable<MyOrderInfo> getHaveFinishedOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);
    //15. 已取消(有缓存)  http://49.122.47.185:8080/XJD/api/OrderCancelServlet?userId=7&pageindex=1
    @GET("OrderCancelServlet")
    Observable<MyOrderInfo> getHaveCanceledOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);

    //16.订单详情-商品详情，根据orderId查询商品详情(有缓存) http://49.122.47.185:8080/XJD/api/OrderGoodsServlet?orderId=211
    @GET("OrderGoodsServlet")
    Observable<OrdergoodsInfo> getOrderInfoByOrderId(@Query("orderId") int orderId);

    //17.  7.21新 搜索 (有缓存) http://49.122.47.185:8080/XJD/api/SearchSevlet?keywords=手机&pageindex=1
    @GET("SearchSevlet")
    Observable<HomeWares> getSearchSevletByKeywordsAndPageindex(@Query("keywords") String keywords,@Query("pageindex") int pageindex);

    //15. 用户信息编辑  http://49.122.47.185:8080/XJD/api/UserInfoUpdateServlet
    //待完成

    //18. 用户地址(有缓存)http://10.10.140.231:8080/XJD/api/UserAddressServlet?userId=7
    @GET("UserAddressServlet")
    Observable<Address> getUserAddressByUserId(@Query("userId") int userId);
    //19待收货 （有缓存） http://10.10.140.231:8080/XJD/api/WaitShipServlet?userId=7&pageindex=1
    @GET("WaitShipServlet")
    Observable<MyOrderInfo> getWaitShipOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);
}


