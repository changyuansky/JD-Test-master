package com.sxjs.common.model;

import android.content.Context;

import com.sxjs.common.bean.ClassFication;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.common.bean.OrdergoodsInfo;
import com.sxjs.common.bean.ShopCar;
import com.sxjs.common.bean.UserInfo;
import com.sxjs.common.cache.CacheProvider;
import com.sxjs.common.model.dao.DataBaseHelper;
import com.sxjs.common.model.http.BaseApiService;
import com.sxjs.common.model.http.HttpHelper;
import com.sxjs.common.model.sp.SharePreferenceHelper;

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

//    public Disposable getMainData(DisposableObserver<HomeWares> consumer){
//        //在真实开发中此处需要被替换方可作为请求接口参数使用
//        return changeIOToMainThread(httpHelper.getService(BaseApiService.class)
//                .getHomeWares(oldPageindex),consumer);
//
//    }

//    private Disposable changeIOToMainThread(Observable<HomeWares> observable ,DisposableObserver<HomeWares> consumer ){
//        return observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(consumer);
//    }

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

//    public List<String> getTypeOfNameData(){
//        ArrayList<String> list = new ArrayList<>(20);
//        for (int i = 0; i < 20; i++) {
//            list.add("家用电器");
//        }
//        return list;
//    }


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
     //5.注册后获得用户信息
    public void getRegistUserInfo(final DisposableObserver<UserInfo> userInfoConsumer, RequestBody registUserInfo){
        Observable<UserInfo> registuserInfoObservable=getBaseApiService().postRegistUserInfo(registUserInfo);
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
    public void getLoginUserInfo(DisposableObserver<UserInfo> loginConsumer ,RequestBody postLoginUserInfo){
        Observable<UserInfo> loginuserInfoObservable=getBaseApiService().postLoginUserInfo(postLoginUserInfo);
        toSubscribe(loginuserInfoObservable,loginConsumer);
    }

    //8.根据手机号获取验证码
    public void getVcode(DisposableObserver<String> vCodeConsumer, RequestBody phoneNum){
        Observable<String> vCodeObservable=getBaseApiService().getVcode(phoneNum);
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
                getNoPayOrderInfoByUserIdAndPageindex(getBaseApiService().getNoPayOrderInfoByUserIdAndPageindex(userId,pageindex),
                        new DynamicKeyGroup(userId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,noPayOrderInfoConsumer);
    }
    //13. 待发货


    //14  已完成订单
    public void getHaveFinishedOrderInfoByUserIdAndPageindex(DisposableObserver<MyOrderInfo> haveFinishedOrderInfoConsumer,int userId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getHaveFinishedOrderInfoByUserIdAndPageindex(getBaseApiService().getHaveFinishedOrderInfoByUserIdAndPageindex(userId,pageindex),
                        new DynamicKeyGroup(userId,pageindex),new EvictProvider(update));
        toSubscribe(orderObservable,haveFinishedOrderInfoConsumer);
    }
    //15.已取消订单getHaveCanceledOrderInfoByUserIdAndPageindex
    public void getHaveCanceledOrderInfoByUserIdAndPageindex(DisposableObserver<MyOrderInfo> haveCanceledOrderInfoConsumer,int userId,int pageindex,boolean update){
        Observable<MyOrderInfo> orderObservable=cacheProvider.
                getHaveCanceledOrderInfoByUserIdAndPageindex(getBaseApiService().getHaveCanceledOrderInfoByUserIdAndPageindex(userId,pageindex),
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