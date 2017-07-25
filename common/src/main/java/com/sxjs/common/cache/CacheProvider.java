package com.sxjs.common.cache;




import com.sxjs.common.bean.Address;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.common.bean.OrdergoodsInfo;
import com.sxjs.common.bean.ShopCar;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.DynamicKeyGroup;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;


//CacheProvider——RxCache的缓存接口，
// 注意它的第一个参数类型必须和Retrofit数据请求接口的返回值类型一样。
public interface CacheProvider {
    //1.主页最下方推荐商品
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<HomeWares> getHomeWares(Observable<HomeWares> homeWaresObservable,
                                       EvictProvider evictProvider, DynamicKey pageindex);
    //2.  首页轮播图和特价商品
    @LifeCache(duration = 2, timeUnit = TimeUnit.DAYS)
    Observable<HomeWares> getHomeBannerImgAndBargainGoods(Observable<HomeWares> homeIndexObservable,
                                               EvictProvider evictProvider);
    //3 获取分类 根据parentId 获取数据
    @LifeCache(duration = 5, timeUnit = TimeUnit.DAYS)
    Observable<ClassFication> getClassFication(Observable<ClassFication> classFictionObservable,
                                               DynamicKey parentId,EvictProvider evictProvider);
    //4 分类 根据分类catId Pageindex请求相应产品的详细信息
    @LifeCache(duration = 5, timeUnit = TimeUnit.DAYS)
    Observable<HomeWares> getCatGoodsInfoByCatIdAndPageindex(Observable<HomeWares> catGoodsMoreInfo ,
                                                             EvictProvider evictProvider,DynamicKeyGroup catId_pageindex);

//    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
//    Observable<UserInfo> getUserInfo(Observable<UserInfo> userInfoObservable ,
//                                     EvictProvider evictProvider);
    //6 获得特价商品
//    @LifeCache(duration = 5, timeUnit = TimeUnit.DAYS)
//    Observable<HomeWares> getBargainGoods(Observable<HomeWares> bargainGoodsObservable ,
//                                             EvictProvider evictProvider);
    //9 购物车+分页
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<ShopCar> getShopCarInfoByuserIdAndPageindex(Observable<ShopCar> shopCarObservable ,
                                                           DynamicKeyGroup userId_pageindex,EvictProvider evictProvider);
    //10  商品详情
    Observable<HomeWares> getGoodsInfoBygoodsId(Observable<HomeWares> goodsObservable,
                                                DynamicKey goodsId,EvictProvider evictProvider);
    //11.全部订单+分页
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<MyOrderInfo> getOrderInfoByUserIdAndPageindex(Observable<MyOrderInfo> allOrderObservable,
                                                             DynamicKeyGroup userId_pageindex,EvictProvider evictProvider);
    //12 未付款订单
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<MyOrderInfo> getNoPayOrderInfoByUserIdAndPageindex(Observable<MyOrderInfo> noPayOrderObservable,
                                                                  DynamicKeyGroup userId_pageindex,EvictProvider evictProvider);
    //13. 待发货

    //14  已完成订单
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<MyOrderInfo> getHaveFinishedOrderInfoByUserIdAndPageindex(Observable<MyOrderInfo> haveFinishedOrderObservable,
                                                                         DynamicKeyGroup userId_pageindex,EvictProvider evictProvider);
    //15.已取消订单
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<MyOrderInfo> getHaveCanceledOrderInfoByUserIdAndPageindex(Observable<MyOrderInfo> haveCanceledOrderObservable,
                                                                         DynamicKeyGroup userId_pageindex,EvictProvider evictProvider);
    //16.订单详情-商品详情，根据orderId查询商品详情
    @LifeCache(duration = 2, timeUnit = TimeUnit.DAYS)
    Observable<OrdergoodsInfo> getOrderInfoByOrderId(Observable<OrdergoodsInfo> orderObservable,
                                                DynamicKey orderId,EvictProvider evictProvider);
    //17. 搜索
    Observable<HomeWares> getSearchSevletByKeywordsAndPageindex(Observable<HomeWares> searchObservable,
                                                                DynamicKeyGroup keywords_pageindex,EvictProvider evictProvider);
    //18 用户地址
    Observable<Address> getUserAddressByUserId(Observable<Address> addressObservable,
                                               DynamicKey userId,EvictProvider evictProvider);
}