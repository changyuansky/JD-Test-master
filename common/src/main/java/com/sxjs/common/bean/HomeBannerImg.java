package com.sxjs.common.bean;

import com.sxjs.common.base.baseadapter.entity.MultiItemEntity;
import com.sxjs.common.data.Constant;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */

public class HomeBannerImg {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : null
     * timstamp : 1500169103840
     * pageindex : 0
     * items : [{"itemType":"topBanner","module":"topBanner","itemList":[{"adId":90,"positionId":65,"adCode":"49.122.47.185:8080/XJD/data/images/afficheimg/20150722uzphik.jpg","adName":"首页幻灯片1"},{"adId":91,"positionId":65,"adCode":"49.122.47.185:8080/XJD/data/images/afficheimg/20150722zsmllz.jpg","adName":"首页幻灯片2"},{"adId":92,"positionId":65,"adCode":"49.122.47.185:8080/XJD/data/images/afficheimg/20150723axsewo.jpg","adName":"首页幻灯片3"}]}]
     */

    public String code;
    public String msg;
    public Object isOver;
    public long timstamp;
    public int pageindex;
    public List<ItemsBean> items;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public long getTimstamp() {
        return timstamp;
    }

    public void setTimstamp(long timstamp) {
        this.timstamp = timstamp;
    }


    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean implements MultiItemEntity {
        /**
         * itemType : topBanner
         * module : topBanner
         * itemList : [{"adId":90,"positionId":65,"adCode":"49.122.47.185:8080/XJD/data/images/afficheimg/20150722uzphik.jpg","adName":"首页幻灯片1"},{"adId":91,"positionId":65,"adCode":"49.122.47.185:8080/XJD/data/images/afficheimg/20150722zsmllz.jpg","adName":"首页幻灯片2"},{"adId":92,"positionId":65,"adCode":"49.122.47.185:8080/XJD/data/images/afficheimg/20150723axsewo.jpg","adName":"首页幻灯片3"}]
         */

        public String itemType;
        public String module;
        public List<ItemListBean> itemList;


        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        @Override
        public int getItemType() {
            //if("topBanner".equals(itemType))
                return Constant.TYPE_TOP_BANNER;

            //return Constant.TYPE_RECOMMENDED_WARE;
        }

        public int getSpanSize() {
            if("recommended_ware".equals(itemType)){
                return 2;
            }
            return 4;
        }

        public static class ItemListBean {
            /**
             * adId : 90
             * positionId : 65
             * adCode : 49.122.47.185:8080/XJD/data/images/afficheimg/20150722uzphik.jpg
             * adName : 首页幻灯片1
             */

            public int adId;
            public int positionId;
            public String adCode;
            public String adName;

            public int getAdId() {
                return adId;
            }

            public void setAdId(int adId) {
                this.adId = adId;
            }

            public int getPositionId() {
                return positionId;
            }

            public void setPositionId(int positionId) {
                this.positionId = positionId;
            }

            public String getAdCode() {
                return adCode;
            }

            public void setAdCode(String adCode) {
                this.adCode = adCode;
            }

            public String getAdName() {
                return adName;
            }

            public void setAdName(String adName) {
                this.adName = adName;
            }
        }
    }
}
