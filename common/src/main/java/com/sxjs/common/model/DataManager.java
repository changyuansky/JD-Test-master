package com.sxjs.common.model;

import android.content.Context;

import com.google.gson.Gson;
import com.sxjs.common.bean.Address;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.common.bean.OrdergoodsInfo;
import com.sxjs.common.bean.Region;
import com.sxjs.common.bean.ShopCar;
import com.sxjs.common.bean.UserInfo;
import com.sxjs.common.cache.CacheProvider;
import com.sxjs.common.model.dao.DataBaseHelper;
import com.sxjs.common.model.http.BaseApiService;
import com.sxjs.common.model.http.HttpHelper;
import com.sxjs.common.model.sp.SharePreferenceHelper;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.DynamicKeyGroup;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.EvictProvider;
import okhttp3.RequestBody;

/**
 * Created by admin on 2017/3/9.
 */
@Singleton
public class DataManager {

    private HttpHelper httpHelper;

    private SharePreferenceHelper sharePreferenceHelper;

    private DataBaseHelper dataBaseHelper;

    private Context context;
    private CacheProvider cacheProvider;

    @Inject
    public DataManager( Context context ,HttpHelper httpHelper , SharePreferenceHelper sharePreferenceHelper
        , DataBaseHelper dataBaseHelper) {
        this.context = context;
        this.httpHelper = httpHelper;
        this.sharePreferenceHelper = sharePreferenceHelper;
        this.dataBaseHelper = dataBaseHelper;
        cacheProvider = httpHelper.getCacheProvider();
    }

    public void saveSPData(String key , String value){
        sharePreferenceHelper.saveData(key , value);
    }

    public void saveSPMapData(Map<String,String> map){
        sharePreferenceHelper.saveData(map);
    }

    public String getSPData(String key){
        return sharePreferenceHelper.getValue(key);
    }

    public void deleteSPData(){
        sharePreferenceHelper.deletePreference();
    }

    public Map<String ,String> getSPMapData(){
        return sharePreferenceHelper.readData();
    }


    //1.1  推荐商品,分页功能，由pageindex传入   EvictDynamicKey：update决定是否时刻更新数据
    public void getHomeWares(final DisposableObserver<HomeWares> consumer, int pageindex, final boolean update){
        Observable<HomeWares> homeWaresObservable= cacheProvider
                .getHomeWares(getBaseApiService().getHomeWares(pageindex),
                        new EvictDynamicKey(update),new DynamicKey(pageindex));
        toSubscribe(homeWaresObservable,consumer);
    }
    //1.2进入主页时获得 推荐商品 对象
     public void getMoreHomeWares(final DisposableObserver<HomeWares> consumer, final int pageindex , final boolean update) {
        Observable<HomeWares> homeWaresObservable=cacheProvider
                .getHomeWares(getBaseApiService().getHomeWares(pageindex),
                new EvictDynamicKey(update),new DynamicKey(pageindex));
         toSubscribe(homeWaresObservable,consumer);
     }
    //2.获得TopBanner数据（HomeBanner对象）
//    public void getHomeBannerImg(final DisposableObserver<HomeBannerImg> homeBannerImgConsumer, final boolean updateHomeBannerImg){
//        Observable<HomeBannerImg>  homeBannerImgObservable = cacheProvider
//                .getHomeBannerImg(getBaseApiService().getHomeBannerImg(),
//                        new EvictProvider(updateHomeBannerImg));
//        toSubscribe(homeBannerImgObservable,homeBannerImgConsumer);
//    }
    //3. 获得分类数据（ClassFication 对象）
    public void getClassFication(final DisposableObserver<ClassFication> classFicationConsumer , final int parentId,final boolean updateClassfication){
        Observable<ClassFication> classFicationObservable=cacheProvider
                .getClassFication(getBaseApiService().getClassFication(),
                        new DynamicKey(parentId),new EvictProvider(updateClassfication));//需要parentId作为分页标准？？？
        toSubscribe(classFicationObservable,classFicationConsumer);
    }
     //4.需要根据catId ,pageindex获取相应数据
    public void getCatGoodsInfoByCatIdAndPageindex(final DisposableObserver<HomeWares> classGoodsInfoConsumer , final int catId,int pageindex,final boolean update){
        Observable<HomeWares> classGoodsInfoObservable=cacheProvider
                .getCatGoodsInfoByCatIdAndPageindex(getBaseApiService().getCatGoodsInfoByCatIdAndPageindex(catId,pageindex),
                        new EvictProvider(update),new DynamicKeyGroup(catId,pageindex));
        toSubscribe(classGoodsInfoObservable,classGoodsInfoConsumer);
    }
     //5.对象传入，注册后获得用户信息
    public<T> void getRegistUserInfo(final DisposableObserver<UserInfo> userInfoConsumer,T registUserInfo){
        RequestBody registUserInfobody = toRequestBody(registUserInfo);
        Observable<UserInfo> registuserInfoObservable=getBaseApiService().postRegistUserInfo(registUserInfobody );
        toSubscribe(registuserInfoObservable,userInfoConsumer);
    }
    //6.获得主页特价商品
    public void getHomeBannerImgAndBargainGoods(final DisposableObserver<HomeWares> bargainGoodsConsumer, final boolean updateBargainGoods){
        Observable<HomeWares>  bargainGoodsObservable = cacheProvider
                .getHomeBannerImgAndBargainGoods(getBaseApiService().getHomeBannerImgAndBargainGoods(),
                        new EvictProvider(updateBargainGoods));
        toSubscribe(bargainGoodsObservable,bargainGoodsConsumer);
    }
    //7.登陆，根据用户登录信息获取用户详细信息
    /*
    *@ postLoginUserInfo 用户登录时需要上传的信息(注：用户信息需要转化为Json格式)
     */
    public<T> void getLoginUserInfo(DisposableObserver<UserInfo> loginConsumer ,T postLoginUserInfo){
        RequestBody body = toRequestBody(postLoginUserInfo);
        Observable<UserInfo> loginuserInfoObservable=getBaseApiService().postLoginUserInfo(body);
        toSubscribe(loginuserInfoObservable,loginConsumer);
    }

    //8.根据手机号获取验证码
    /*
    * @ 返回值中只有code 和 msg ，验证码就在msg中
    * */
    public  void getVcode(DisposableObserver<UserInfo> vCodeConsumer, String mobilePhone){
        //RequestBody body = toRequestBody(phoneNum);
        Observable<UserInfo> vCodeObservable=getBaseApiService().getVcode(mobilePhone);
        toSubscribe(vCodeObservable,vCodeConsumer);
    }

    //9.根据userId ,pageindex获取购物车商品品信息
    public void getShopCarInfo(DisposableObserver<ShopCar> shopCarConsumer,int userId,int pageindex,final boolean update){
        Observable<ShopCar> shopCarObservable= cacheProvider
                .getShopCarInfoByuserIdAndPageindex(getBaseApiService().getShopCarInfoByuserIdAndPageindex(userId,pageindex),
                        new DynamicKeyGroup(userId,pageindex),new EvictDynamicKey(update));
        toSubscribe(shopCarObservable,shopCarConsumer);
    }

    //10 根据 “goodsId”获取商品详情
    public void getGoodsInfoByGoodsId(DisposableObserver<HomeWares> goodsInfoConsumer,int goodsId,boolean update){
        Observable<HomeWares> goodsObservable=cacheProvider.
                getGoodsInfoBygoodsId(getBaseApiService().getGoodsInfoBygoodsId(goodsId),
                        new DynamicKey(goodsId),new EvictDynamicKey(update));
        toSubscribe(goodsObservable,goodsInfoConsumer);
    }
    //11.根据 “userId”和“pageindex” 订单详情
    public void getOrderInfoByUserIdAndPageindex(DisposableObserver<MyOrderInfo> orderInfoConsumer,int userId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getOrderInfoByUserIdAndPageindex(getBaseApiService().getOrderInfoByUserIdAndPageindex(userId,pageindex),
                        new DynamicKeyGroup(userId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,orderInfoConsumer);
    }
    //12 未付款订单  getNoPayOrderInfoByUserIdAndPageindex
    public void getNoPayOrderInfoByUserIdAndPageindex(DisposableObserver<MyOrderInfo> noPayOrderInfoConsumer,int userId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getNoPayOrderInfoByUserIdAndPageindex(getBaseApiService().getNoPayOrderInfoByUserIdAndPageindex(userId,pageindex,0,1),
                        new DynamicKeyGroup(userId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,noPayOrderInfoConsumer);
    }
    //13. 待发货
    public void getShipNoOrderInfoByUserIdAndPageindex(DisposableObserver<MyOrderInfo> shipNoOrderInfoConsumer,int userId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getShipNoOrderInfoByUserIdAndPageindex(getBaseApiService().getShipNoOrderInfoByUserIdAndPageindex(userId,pageindex,0,2),
                        new DynamicKeyGroup(userId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,shipNoOrderInfoConsumer);
    }
    //14  已完成订单
    public void getHaveFinishedOrderInfoByUserIdAndPageindex(DisposableObserver<MyOrderInfo> haveFinishedOrderInfoConsumer,int userId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getHaveFinishedOrderInfoByUserIdAndPageindex(getBaseApiService().getHaveFinishedOrderInfoByUserIdAndPageindex(userId,pageindex,2),
                        new DynamicKeyGroup(userId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,haveFinishedOrderInfoConsumer);
    }
    //15.已取消订单getHaveCanceledOrderInfoByUserIdAndPageindex
    public void getHaveCanceledOrderInfoByUserIdAndPageindex(DisposableObserver<MyOrderInfo> haveCanceledOrderInfoConsumer,int userId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getHaveCanceledOrderInfoByUserIdAndPageindex(getBaseApiService().getHaveCanceledOrderInfoByUserIdAndPageindex(userId,pageindex,2),
                        new DynamicKeyGroup(userId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,haveCanceledOrderInfoConsumer);
    }
    //16.根据 “orderId”获取商品详情
    public void getGoodsInfoByOrderId(DisposableObserver<OrdergoodsInfo> goodsInfoByOrderIdConsumer,int orderId,boolean update){
        Observable<OrdergoodsInfo> goodsByOrderIdObservable=cacheProvider.
                getOrderInfoByOrderId(getBaseApiService().getOrderInfoByOrderId(orderId),
                        new DynamicKey(orderId),new EvictProvider(update));
        toSubscribe(goodsByOrderIdObservable,goodsInfoByOrderIdConsumer);
    }
    //17. 搜索
    public void getSearchSevletByKeywordsAndPageindex(DisposableObserver<HomeWares> searchConsumer,String keywords,int pageindex,boolean update){
        Observable<HomeWares> SearchObservable=cacheProvider.
                getSearchSevletByKeywordsAndPageindex(getBaseApiService().getSearchSevletByKeywordsAndPageindex(keywords,pageindex),
                        new DynamicKeyGroup(keywords,pageindex),new EvictProvider(update));
        toSubscribe(SearchObservable,searchConsumer);
    }
    //18 用户收货地址
    public void getUserAddressByUserId(DisposableObserver<Address> userAddressByUserIdConsumer, int userId, boolean update){
        Observable<Address> goodsByOrderIdObservable=cacheProvider.
                getShippingAddressByUserId(getBaseApiService().getAddressByUserId(userId),
                        new DynamicKey(userId),new EvictProvider(update));
        toSubscribe(goodsByOrderIdObservable,userAddressByUserIdConsumer);
    }
    //19  待收货
    public void getWaitShipOrderInfoByUserIdAndPageindex(DisposableObserver<MyOrderInfo> waitShipOrderInfoConsumer,int userId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getWaitShipOrderInfoByUserIdAndPageindex(getBaseApiService().getWaitShipOrderInfoByUserIdAndPageindex(userId,pageindex,1),
                        new DynamicKeyGroup(userId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,waitShipOrderInfoConsumer);
    }
    //20 删除订单
    public void getDeleteOrderInfoByOrderId(DisposableObserver<MyOrderInfo> deleteOrderInfoConsumer,int orderId,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getDeleteOrderInfoByOrderId(getBaseApiService().getDeleteOrderInfoByOrderId(orderId),
                        new DynamicKey(orderId),new EvictProvider(update));
        toSubscribe(orderObservable,deleteOrderInfoConsumer);
    }
    //21退货
    public void getBackOrderInfoByOrderIdAndPageindex(DisposableObserver<MyOrderInfo> backOrderInfoConsumer,int orderId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getBackOrderInfoByOrderIdAndPageindex(getBaseApiService().getBackOrderInfoByOrderIdAndPageindex(orderId,pageindex),
                        new DynamicKeyGroup(orderId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,backOrderInfoConsumer);
    }
    //22 加入购物车
    public<T> void postAddCar(DisposableObserver<ShopCar> addCarConsumer ,T addCarOrderInfo){
        RequestBody body = toRequestBody(addCarOrderInfo);
        Observable<ShopCar> addCarObservable=getBaseApiService().postAddCar(body);
        toSubscribe(addCarObservable,addCarConsumer);
    }
    //23 删除购物车多个商品 POST 传集合List
    public<T> void postDeleteCars(DisposableObserver<ShopCar> deleteCarsConsumer , List<Integer> shopCarDeleteList) {
        RequestBody body = toRequestBody(shopCarDeleteList);
        Observable<ShopCar> deleteCarsObservable=getBaseApiService().postAddCar(body);
        toSubscribe(deleteCarsObservable,deleteCarsConsumer);
    }
    //24地区
    public void getRegion(DisposableObserver<Region> regionConsumer,boolean update){
        Observable<Region> regionObservable=cacheProvider.
                getRegion(getBaseApiService().getRegion(),new EvictProvider(update));
        toSubscribe(regionObservable,regionConsumer);
    }
    //25添加新地址
    public<T> void  postNewAddress(DisposableObserver<Address> newAddressConsumer,T newAddressInfo){
        RequestBody body = toRequestBody(newAddressConsumer);
        Observable<Address> newAddressObservable=getBaseApiService().postNewAddress(body);
        toSubscribe(newAddressObservable,newAddressConsumer);
    }
    //26 删除购物车，数量减少    getDeleteCarByRecId
    public void getDeleteCarByRecId(DisposableObserver<ShopCar> deleteCarByRecIdConsumer,int recId){
        Observable<ShopCar> deleteCarByRecIdObservable=getBaseApiService().getDeleteCarByRecId(recId);
        toSubscribe(deleteCarByRecIdObservable,deleteCarByRecIdConsumer);
    }


    private<T> RequestBody toRequestBody(T t){
        String info = new Gson().toJson(t);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),info);
        return body;
    }
     //BaseApiService实例
     private BaseApiService getBaseApiService(){
         return httpHelper.getService(BaseApiService.class);
     }
     //订阅
      private  <T> void toSubscribe(Observable<T> observable,DisposableObserver<T> consumer){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
      }
}