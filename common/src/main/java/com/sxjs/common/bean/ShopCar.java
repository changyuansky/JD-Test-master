package com.sxjs.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class ShopCar {
    /**
     * code : 200
     * msg : 访问成功
     * isOver : null
     * timstamp : 1500431071653
     * pageindex : 0
     * items : [{"itemType":"shopcar","module":"shopcar","itemList":[{"recId":4,"userId":7,"goodsId":291,"goodsSn":"ED23188167","productId":55,"goodsName":"女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233","marketPrice":119,"goodsPrice":81,"goodsNumber":1,"goodsAttrId":"[I@75410f2a","addTime":"2017-07-18","goodsAttr":"尺码:S"},{"recId":5,"userId":7,"goodsId":292,"goodsSn":"EN1232133600","productId":0,"goodsName":"一加手机3T (A3010) 6GB+64GB 枪灰版 全网通 双卡双待 移动联通电信4G手机","marketPrice":3333,"goodsPrice":2399,"goodsNumber":1,"goodsAttrId":"","addTime":"2017-07-18","goodsAttr":""},{"recId":6,"userId":7,"goodsId":291,"goodsSn":"ED23188167","productId":55,"goodsName":"女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233","marketPrice":119,"goodsPrice":81,"goodsNumber":1,"goodsAttrId":"[I@3f91010","addTime":"2017-07-18","goodsAttr":"尺码:S"}]}]
     */

    public String code;
    public String msg;
    public Object isOver;
    public long timstamp;
    public int pageindex;
    public List<ItemsBean> items;

    public static class ItemsBean {
        /**
         * itemType : shopcar
         * module : shopcar
         * itemList : [{"recId":4,"userId":7,"goodsId":291,"goodsSn":"ED23188167","productId":55,"goodsName":"女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233","marketPrice":119,"goodsPrice":81,"goodsNumber":1,"goodsAttrId":"[I@75410f2a","addTime":"2017-07-18","goodsAttr":"尺码:S"},{"recId":5,"userId":7,"goodsId":292,"goodsSn":"EN1232133600","productId":0,"goodsName":"一加手机3T (A3010) 6GB+64GB 枪灰版 全网通 双卡双待 移动联通电信4G手机","marketPrice":3333,"goodsPrice":2399,"goodsNumber":1,"goodsAttrId":"","addTime":"2017-07-18","goodsAttr":""},{"recId":6,"userId":7,"goodsId":291,"goodsSn":"ED23188167","productId":55,"goodsName":"女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233","marketPrice":119,"goodsPrice":81,"goodsNumber":1,"goodsAttrId":"[I@3f91010","addTime":"2017-07-18","goodsAttr":"尺码:S"}]
         */

        public String itemType;
        public String module;
        public List<ItemListBean> itemList;

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

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

        public static class ItemListBean {
            /**
             * recId : 4
             * userId : 7
             * goodsId : 291
             * goodsSn : ED23188167
             * productId : 55
             * goodsName : 女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233
             * marketPrice : 119
             * goodsPrice : 81
             * goodsNumber : 1
             * goodsAttrId : [I@75410f2a
             * addTime : 2017-07-18
             * goodsAttr : 尺码:S
             */

            public int recId;
            public int userId;
            public int goodsId;
            public String goodsSn;
            public int productId;
            public String goodsName;
            public int marketPrice;
            public int goodsPrice;
            public int goodsNumber;
            public String goodsAttrId;
            public String addTime;
            public String goodsAttr;

            public int getRecId() {
                return recId;
            }

            public void setRecId(int recId) {
                this.recId = recId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsSn() {
                return goodsSn;
            }

            public void setGoodsSn(String goodsSn) {
                this.goodsSn = goodsSn;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(int marketPrice) {
                this.marketPrice = marketPrice;
            }

            public int getGoodsPrice() {
                return goodsPrice;
            }

            public void setGoodsPrice(int goodsPrice) {
                this.goodsPrice = goodsPrice;
            }

            public int getGoodsNumber() {
                return goodsNumber;
            }

            public void setGoodsNumber(int goodsNumber) {
                this.goodsNumber = goodsNumber;
            }

            public String getGoodsAttrId() {
                return goodsAttrId;
            }

            public void setGoodsAttrId(String goodsAttrId) {
                this.goodsAttrId = goodsAttrId;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public String getGoodsAttr() {
                return goodsAttr;
            }

            public void setGoodsAttr(String goodsAttr) {
                this.goodsAttr = goodsAttr;
            }
        }
    }
}
