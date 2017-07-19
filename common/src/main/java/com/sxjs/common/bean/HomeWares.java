package com.sxjs.common.bean;

import android.util.Log;

import com.sxjs.common.base.baseadapter.entity.MultiItemEntity;
import com.sxjs.common.data.Constant;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class HomeWares {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : 0
     * timstamp : 1500283434781
     * pageindex : 1
     * items : [{"itemType":"recommended_ware","module":"recommended","itemList":[{"goodsId":5,"goodsName":"半壳扇贝 扇贝肉 1000g/新鲜扇贝冷冻烧烤海鲜","shopPrice":58,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/5_thumb_G_1437502904492.jpg","catId":0},{"goodsId":6,"goodsName":"【宅鲜配】半壳扇贝 扇贝肉 1000g/新鲜扇贝冷冻烧烤海鲜 ","shopPrice":58,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/6_thumb_G_1437503036629.jpg","catId":0},{"goodsId":8,"goodsName":"小金蛋童鞋女童皮鞋 可爱卡通装饰 甜美公主范 优质纯牛皮","shopPrice":79,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/8_thumb_G_1437505162875.jpg","catId":0},{"goodsId":9,"goodsName":"小金蛋女童皮鞋儿童公主鞋韩版单鞋休闲女童鞋翅膀鞋2015新款秋款","shopPrice":0,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/9_thumb_G_1437505965177.jpg","catId":0},{"goodsId":10,"goodsName":"越南红心火龙果5斤装 红肉火龙果 新鲜进口水果","shopPrice":35,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/10_thumb_G_1437503428257.jpg","catId":0},{"goodsId":11,"goodsName":"七果果 越南白心火龙果1斤【3斤起拍，只多不少】 毁包赔 进口新鲜水果 堪比红心火龙果","shopPrice":30,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/11_thumb_G_1437503527861.jpg","catId":0},{"goodsId":12,"goodsName":"大童装女童夏装套装2015夏季新款儿童短袖女孩运动两件套宝宝短裤","shopPrice":69,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/12_thumb_G_1437505924891.jpg","catId":0},{"goodsId":13,"goodsName":"诚绿丰 越南进口红肉火龙果 新鲜水果红心火龙果 江浙沪皖包邮 1斤装","shopPrice":18,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/13_thumb_G_1437503573325.jpg","catId":0},{"goodsId":14,"goodsName":"哥伦比亚金燕窝果 新鲜进口水果 麒麟果 黄色白心火龙果 4只","shopPrice":121,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/14_thumb_G_1437503630878.jpg","catId":0},{"goodsId":15,"goodsName":"童装女童2015新款夏装韩版潮儿童衣服中大童短袖短裤休闲套装夏季","shopPrice":139,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/15_thumb_G_1437506048990.jpg","catId":0}]}]
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

    public static class ItemsBean implements MultiItemEntity {
        /**
         * itemType : recommended_ware
         * module : recommended
         * itemList : [{"goodsId":5,"goodsName":"半壳扇贝 扇贝肉 1000g/新鲜扇贝冷冻烧烤海鲜","shopPrice":58,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/5_thumb_G_1437502904492.jpg","catId":0},{"goodsId":6,"goodsName":"【宅鲜配】半壳扇贝 扇贝肉 1000g/新鲜扇贝冷冻烧烤海鲜 ","shopPrice":58,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/6_thumb_G_1437503036629.jpg","catId":0},{"goodsId":8,"goodsName":"小金蛋童鞋女童皮鞋 可爱卡通装饰 甜美公主范 优质纯牛皮","shopPrice":79,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/8_thumb_G_1437505162875.jpg","catId":0},{"goodsId":9,"goodsName":"小金蛋女童皮鞋儿童公主鞋韩版单鞋休闲女童鞋翅膀鞋2015新款秋款","shopPrice":0,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/9_thumb_G_1437505965177.jpg","catId":0},{"goodsId":10,"goodsName":"越南红心火龙果5斤装 红肉火龙果 新鲜进口水果","shopPrice":35,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/10_thumb_G_1437503428257.jpg","catId":0},{"goodsId":11,"goodsName":"七果果 越南白心火龙果1斤【3斤起拍，只多不少】 毁包赔 进口新鲜水果 堪比红心火龙果","shopPrice":30,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/11_thumb_G_1437503527861.jpg","catId":0},{"goodsId":12,"goodsName":"大童装女童夏装套装2015夏季新款儿童短袖女孩运动两件套宝宝短裤","shopPrice":69,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/12_thumb_G_1437505924891.jpg","catId":0},{"goodsId":13,"goodsName":"诚绿丰 越南进口红肉火龙果 新鲜水果红心火龙果 江浙沪皖包邮 1斤装","shopPrice":18,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/13_thumb_G_1437503573325.jpg","catId":0},{"goodsId":14,"goodsName":"哥伦比亚金燕窝果 新鲜进口水果 麒麟果 黄色白心火龙果 4只","shopPrice":121,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/14_thumb_G_1437503630878.jpg","catId":0},{"goodsId":15,"goodsName":"童装女童2015新款夏装韩版潮儿童衣服中大童短袖短裤休闲套装夏季","shopPrice":139,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/15_thumb_G_1437506048990.jpg","catId":0}]
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
            if("goodsindex".equals(itemType)){
                return Constant.TYPE_JD_SPIKE_CONTENT;
            }
            else if("recommended_ware".equals(itemType)){
                return Constant.TYPE_RECOMMENDED_WARE;
            }
            return Constant.TYPE_RECOMMENDED_WARE;
        }

        public int getSpanSize() {

            if("recommended_ware".equals(itemType)){
                return 2;
            }
            return 4;
        }
//goodsId":5,"goodsName":"半壳扇贝 扇贝肉 1000g/新鲜扇贝冷冻烧烤海鲜","shopPrice":58,"goodsThumb":"data/images/201507/thumb_img/5_thumb_G_1437502904492.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":0,"saleNum":0
        public static class ItemListBean {
            public int goodsId;
            public String goodsName;
            public int shopPrice;
            public String goodsThumb;
            public int catId;
            public int promotePrice;
            public int isPromote;
            public int isHot;
            public int saleNum;

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getShopPrice() {
                return shopPrice;
            }

            public void setShopPrice(int shopPrice) {
                this.shopPrice = shopPrice;
            }

            public String getGoodsThumb() {
                return goodsThumb;
            }

            public void setGoodsThumb(String goodsThumb) {
                this.goodsThumb = goodsThumb;
            }

            public int getCatId() {
                return catId;
            }

            public void setCatId(int catId) {
                this.catId = catId;
            }

    public int getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(int promotePrice) {
        this.promotePrice = promotePrice;
    }

    public int getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(int isPromote) {
        this.isPromote = isPromote;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }
        }
    }
}
