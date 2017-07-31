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
import com.sxjs.common.bean.Region;
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

    //1 获得主页最下方推荐商品(有缓存) http://localhost:81/shop/api/index/goods?pageindex=1
    @GET("api/index/goods")
    Observable<HomeWares> getHomeWares(@Query("pageindex") int pageindex);

    //2.  获取首页轮播图和特价商品(有缓存) http://localhost:81/shop/api/index/adAndPromot
    @GET("api/index/adAndPromot")
    Observable<HomeWares> getHomeBannerImgAndBargainGoods();

    //3 获取分类(有缓存)http://localhost:81/shop/api/category/allCat
    @GET("api/category/allCat")
    Observable<ClassFication> getClassFication();

    //4.   根据分类catId  pageindex请求相应产品的 详细信息+分页(有缓存)
    // http://localhost:81/shop/api/category/goods?catId=14&pageindex=1
    @GET("api/category/goods")
    Observable<HomeWares> getCatGoodsInfoByCatIdAndPageindex(@Query("catId") int catId,@Query("pageindex") int pageindex);

    //5 用户注册,并返回用户详细信息(无缓存) http://localhost:81/shop/api/registController/regist
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("api/registController/regist")
    Observable<UserInfo> postRegistUserInfo(@Body RequestBody Body);

    //6 获得特价商品(有缓存)
//    @GET("GoodsIndexServlet")
//    Observable<HomeWares> getBargainGoods();

    //7 登录，并返回用户信息 (无缓存)http://localhost:81/shop/loginController/login
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("loginController/login")
    Observable<UserInfo> postLoginUserInfo(@Body RequestBody Body);

    //8 根据  手机号， 获取验证码 (无缓存)  http://localhost:81/shop/api/registController/sentVCode?mobilePhone=
    //@Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @GET("registController/sentVCode")
    Observable<UserInfo> getVcode(@Query("mobilePhone") String  mobilePhone);

    //9   购物车+分页 (有缓存) http://localhost:81/shop/api/car/shopcar?userId=7&pageindex=1
    @GET("api/car/shopcar")
    Observable<ShopCar> getShopCarInfoByuserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);

    //10 商品详情(有缓存)   http://localhost:81/shop/api/index/goodsInfo?goodsId=15
    @GET("api/index/goodsInfo")
    Observable<HomeWares> getGoodsInfoBygoodsId(@Query("goodsId") int goodsId);

    //11   全部订单+分页(有缓存)   http://localhost:81/shop/api/order/info?userId=7&pageindex=1
    @GET("api/order/info")
    Observable<MyOrderInfo> getOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex);

    //12   待付款订单(有缓存)  http://localhost:81/shop/api/order/info?userId=7&pageindex=1&payStatus=0
    @GET("api/order/info")
    Observable<MyOrderInfo> getNoPayOrderInfoByUserIdAndPageindex(@Query("userId") int userId, @Query("pageindex") int pageindex, @Query("payStatus") int payStatus,@Query("orderStatus") int orderStatus);
    // 13 . 待发货 http://localhost:81/shop/api/order/info?userId=7&pageindex=1&shippingStatus=0&payStatus=2
    @GET("api/order/info")
    Observable<MyOrderInfo> getShipNoOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex,
                                                                   @Query("shippingStatus") int shippingStatus,@Query("payStatus") int payStatus);
    //14 . .已完成(有缓存)  http://localhost:81/shop/api/order/info?userId=7&pageindex=1&shippingStatus=2
    @GET("api/order/info")
    Observable<MyOrderInfo> getHaveFinishedOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex,@Query("shippingStatus") int shippingStatus);
    //15. 已取消(有缓存)  http://localhost:81/shop/api/order/info?userId=7&pageindex=1&orderStatus=2
    @GET("api/order/info")
    Observable<MyOrderInfo> getHaveCanceledOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex,@Query("orderStatus") int orderStatus);

    //16.订单详情-商品详情，根据orderId查询商品详情(有缓存) http://localhost:81/shop/api/order/orderInfo?orderId=192
    @GET("api/order/orderInfo")
    Observable<OrdergoodsInfo> getOrderInfoByOrderId(@Query("orderId") int orderId);

    //17.  7.21新 搜索 (有缓存) http://localhost:81/shop/api/index/search?keywords=手机&pageindex=1
    @GET("api/index/search")
    Observable<HomeWares> getSearchSevletByKeywordsAndPageindex(@Query("keywords") String keywords,@Query("pageindex") int pageindex);

    //15. 用户信息编辑  http://49.122.47.185:8080/XJD/api/UserInfoUpdateServlet
    //待完成

    //18. 用户收获地址   http://localhost:81/shop/api/user/address?userId=7
    @GET("api/user/address")
    Observable<Address> getAddressByUserId(@Query("userId") int userId);
    //19待收货 （有缓存） http://localhost:81/shop/api/order/info?userId=7&pageindex=1&shippingStatus=1
    @GET("api/order/info")
    Observable<MyOrderInfo> getWaitShipOrderInfoByUserIdAndPageindex(@Query("userId") int userId,@Query("pageindex") int pageindex,@Query("shippingStatus") int shippingStatus);
    //20 删除订单 (无缓存)  http://localhost:81/shop/api/order/deleteOrder?orderId=193
    @GET("api/order/deleteOrder")
    Observable<MyOrderInfo> getDeleteOrderInfoByOrderId(@Query("orderId") int orderId);
    //21 退货 （有缓存） http://localhost:81/shop/api/order/backOrder?userId=7&pageindex=1
    @GET("api/order/backOrder")
    Observable<MyOrderInfo> getBackOrderInfoByOrderIdAndPageindex(@Query("orderId") int orderId,@Query("pageindex") int pageindex);
    //22 加入购物车(无缓存)  Url:http://localhost:81/shop/api/car/addCar  方式：post   EcsCart 的json格式
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("api/car/addCar")
    Observable<ShopCar> postAddCar(@Body RequestBody Body);
    //23 删除购物车多个商品(无缓存)   Url:http://localhost:81/shop/api/car/deleteCar  方式：post  userId 和 recId[](数组，为了方便多项删除)
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("api/car/deleteCars")
    Observable<ShopCar> postDeleteCars (@Body RequestBody Body);
    //24  地区 (有缓存)   http://localhost:81/shop/api/user/region
    @GET("api/user/region")
    Observable<Region> getRegion();
    //25.添加新地址 (无缓存)     http://localhost:81/shop/api/user/addAddress
    /* 方式：post   ecs_user_address表中所有字段所在的bean类 EcsUserAddress */
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("api/user/addAddress")
    Observable<Address> postNewAddress(@Body RequestBody Body);
    //26 删除购物车，数量减少(无缓存)
    @GET("api/car/reduce")
    Observable<ShopCar> getDeleteCarByRecId (@Query("recId") int recId);

}


