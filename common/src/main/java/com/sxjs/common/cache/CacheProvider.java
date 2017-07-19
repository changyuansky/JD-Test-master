package com.sxjs.common.cache;




import com.sxjs.common.bean.BargainGoods;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.common.bean.HomeBannerImg;
import com.sxjs.common.bean.HomeWares;
import com.sxjs.common.bean.ShopCar;
import com.sxjs.common.bean.UserInfo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import retrofit2.http.Query;


//CacheProvider——RxCache的缓存接口，
// 注意它的第一个参数类型必须和Retrofit数据请求接口的返回值类型一样。
public interface CacheProvider {
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<HomeWares> getHomeWares(Observable<HomeWares> homeWaresObservable,
                                       EvictProvider evictProvider, DynamicKey pageindex);

    @LifeCache(duration = 2, timeUnit = TimeUnit.DAYS)
    Observable<HomeBannerImg> getHomeBannerImg(Observable<HomeBannerImg> bannerImgObservable,
                                               EvictProvider evictProvider);
    //分类一级 根据parentId 获取数据
    @LifeCache(duration = 5, timeUnit = TimeUnit.DAYS)
    Observable<ClassFication> getClassFication(Observable<ClassFication> classFictionObservable,
                                              EvictProvider evictProvider,DynamicKey parentId);
    //分类 根据分类catId 请求相应产品的详细信息
    @LifeCache(duration = 5, timeUnit = TimeUnit.DAYS)
    Observable<HomeWares> getClassMoreInfo(Observable<HomeWares> catGoodsMoreInfo ,
                                           EvictProvider evictProvider,DynamicKey catId);

//    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
//    Observable<UserInfo> getUserInfo(Observable<UserInfo> userInfoObservable ,
//                                     EvictProvider evictProvider);

    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<HomeWares> getBargainGoods(Observable<HomeWares> bargainGoodsObservable ,
                                             EvictProvider evictProvider);

    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<ShopCar> getShopCarInfo(Observable<ShopCar> shopCarObservable ,
                                       EvictProvider evictProvider, DynamicKey userId);


}