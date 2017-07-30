package com.sxjs.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class ShopCar {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : 1
     * timstamp : 1500719703049
     * pageindex : 1
     * items : [{"itemType":"shopcar","module":"shopcar","itemList":[{"rec_id":4,"user_id":7,"goods_id":291,"goods_sn":"ED23188167","product_id":55,"goods_name":"女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233","market_price":119,"goods_price":81,"goods_number":1,"goods_attrId":null,"add_time":1500349011000,"goods_attr":"尺码:S","supplier_name":"小小旗舰店","goods_Img":"49.122.47.185:8080/XJD/data/images/201603/thumb_img/_thumb_P_1458307388786.jpg"},{"rec_id":5,"user_id":7,"goods_id":292,"goods_sn":"EN1232133600","product_id":0,"goods_name":"一加手机3T (A3010) 6GB+64GB 枪灰版 全网通 双卡双待 移动联通电信4G手机","market_price":3333,"goods_price":2399,"goods_number":1,"goods_attrId":null,"add_time":1500349017000,"goods_attr":"","supplier_name":"商城自营","goods_Img":"49.122.47.185:8080/XJD/data/images/20170529/58343dc1Nbb3d4722.jpg"},{"rec_id":6,"user_id":7,"goods_id":291,"goods_sn":"ED23188167","product_id":55,"goods_name":"女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233","market_price":119,"goods_price":81,"goods_number":1,"goods_attrId":null,"add_time":1500349022000,"goods_attr":"尺码:S","supplier_name":"小小旗舰店","goods_Img":"49.122.47.185:8080/XJD/data/images/201603/thumb_img/_thumb_P_1458307388786.jpg"}]}]
     */

    public String code;
    public String msg;
    public String isOver;
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

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    public long getTimstamp() {
        return timstamp;
    }

    public void setTimstamp(long timstamp) {
        this.timstamp = timstamp;
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * itemType : shopcar
         * module : shopcar
         * itemList : [{"rec_id":4,"user_id":7,"goods_id":291,"goods_sn":"ED23188167","product_id":55,"goods_name":"女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233","market_price":119,"goods_price":81,"goods_number":1,"goods_attrId":null,"add_time":1500349011000,"goods_attr":"尺码:S","supplier_name":"小小旗舰店","goods_Img":"49.122.47.185:8080/XJD/data/images/201603/thumb_img/_thumb_P_1458307388786.jpg"},{"rec_id":5,"user_id":7,"goods_id":292,"goods_sn":"EN1232133600","product_id":0,"goods_name":"一加手机3T (A3010) 6GB+64GB 枪灰版 全网通 双卡双待 移动联通电信4G手机","market_price":3333,"goods_price":2399,"goods_number":1,"goods_attrId":null,"add_time":1500349017000,"goods_attr":"","supplier_name":"商城自营","goods_Img":"49.122.47.185:8080/XJD/data/images/20170529/58343dc1Nbb3d4722.jpg"},{"rec_id":6,"user_id":7,"goods_id":291,"goods_sn":"ED23188167","product_id":55,"goods_name":"女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233","market_price":119,"goods_price":81,"goods_number":1,"goods_attrId":null,"add_time":1500349022000,"goods_attr":"尺码:S","supplier_name":"小小旗舰店","goods_Img":"49.122.47.185:8080/XJD/data/images/201603/thumb_img/_thumb_P_1458307388786.jpg"}]
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
             * recId : 13
             * userId : 7
             * goodsId : 232
             * goodsSn : ECS000232
             * productId : 0
             * goodsName : 包邮 新款户外军迷阿帕奇T恤 纯棉男款短袖半袖特价宽松
             * marketPrice : 328.8
             * goodsPrice : 99
             * goodsNumber : 1
             * goodsAttrId :
             * addTime : 1501122399000
             * goodsAttr :
             * supplier_name : 商城自营
             * goodsImg : 10.10.140.231:81/shop/data/images/201507/thumb_img/_thumb_P_1438047501681.jpg
             */

            public int recId;
            public int userId;
            public int goodsId;
            public String goodsSn;
            public int productId;
            public String goodsName;
            public double marketPrice;
            public int goodsPrice;
            public int goodsNumber;
            public String goodsAttrId;
            public long addTime;
            public String goodsAttr;
            public String supplier_name;
            public String goodsImg;
            public boolean select=true;

            public boolean getIsSelect() {
                return select;
            }

            public void setSelect(boolean slect) {
                select = slect;
            }

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

            public double getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(double marketPrice) {
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

            public long getAddTime() {
                return addTime;
            }

            public void setAddTime(long addTime) {
                this.addTime = addTime;
            }

            public String getGoodsAttr() {
                return goodsAttr;
            }

            public void setGoodsAttr(String goodsAttr) {
                this.goodsAttr = goodsAttr;
            }

            public String getSupplier_name() {
                return supplier_name;
            }

            public void setSupplier_name(String supplier_name) {
                this.supplier_name = supplier_name;
            }

            public String getGoodsImg() {
                return goodsImg;
            }

            public void setGoodsImg(String goodsImg) {
                this.goodsImg = goodsImg;
            }
        }
    }
}
