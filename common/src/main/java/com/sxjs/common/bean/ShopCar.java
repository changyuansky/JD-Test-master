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
             * rec_id : 4
             * user_id : 7
             * goods_id : 291
             * goods_sn : ED23188167
             * product_id : 55
             * goods_name : 女人志 新款灯笼袖中领毛衣+韩绒料口袋短裙套装送皮带2233
             * market_price : 119
             * goods_price : 81
             * goods_number : 1
             * goods_attrId : null
             * add_time : 1500349011000
             * goods_attr : 尺码:S
             * supplier_name : 小小旗舰店
             * goods_Img : 49.122.47.185:8080/XJD/data/images/201603/thumb_img/_thumb_P_1458307388786.jpg
             */

            public int rec_id;
            public int user_id;
            public int goods_id;
            public String goods_sn;
            public int product_id;
            public String goods_name;
            public int market_price;
            public int goods_price;
            public int goods_number;
            public Object goods_attrId;
            public long add_time;
            public String goods_attr;
            public String supplier_name;
            public String goods_Img;

            public int getRec_id() {
                return rec_id;
            }

            public void setRec_id(int rec_id) {
                this.rec_id = rec_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public int getMarket_price() {
                return market_price;
            }

            public void setMarket_price(int market_price) {
                this.market_price = market_price;
            }

            public int getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(int goods_price) {
                this.goods_price = goods_price;
            }

            public int getGoods_number() {
                return goods_number;
            }

            public void setGoods_number(int goods_number) {
                this.goods_number = goods_number;
            }

            public Object getGoods_attrId() {
                return goods_attrId;
            }

            public void setGoods_attrId(Object goods_attrId) {
                this.goods_attrId = goods_attrId;
            }

            public long getAdd_time() {
                return add_time;
            }

            public void setAdd_time(long add_time) {
                this.add_time = add_time;
            }

            public String getGoods_attr() {
                return goods_attr;
            }

            public void setGoods_attr(String goods_attr) {
                this.goods_attr = goods_attr;
            }

            public String getSupplier_name() {
                return supplier_name;
            }

            public void setSupplier_name(String supplier_name) {
                this.supplier_name = supplier_name;
            }

            public String getGoods_Img() {
                return goods_Img;
            }

            public void setGoods_Img(String goods_Img) {
                this.goods_Img = goods_Img;
            }
        }
    }
}
