package com.sxjs.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class BargainGoods {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : null
     * timstamp : 1500292810518
     * pageindex : 0
     * items : [{"itemType":"goodsindex","module":"goodsindex","itemList":[{"goodsId":216,"goodsName":"哈罗闪sanosan婴儿洗发露沐浴乳二合一","shopPrice":26,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/216_thumb_G_1437585478147.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":270,"goodsName":"五粮液 45度小酒版 水晶礼盒装 浓香型白酒 官方授权 酒厂直供 中国名酒 250ML","shopPrice":278,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201602/thumb_img/270_thumb_G_1456452662995.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":202,"goodsName":"安索夫迷你电脑USB2.0小音箱可爱熊猫便携笔记本台式电脑音箱 音响","shopPrice":29,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/202_thumb_G_1437534795824.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":41,"goodsName":"小金蛋女宝宝皮鞋夏真皮女童秋鞋公主鞋","shopPrice":99,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/41_thumb_G_1437515470354.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":203,"goodsName":"PowerCube魔方插座接线板 创意多功能荷兰Allocacoc模方插座 办公神器 USB款/无延长线直插(蓝)","shopPrice":49,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/203_thumb_G_1437534951257.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":252,"goodsName":"1.25L雪碧+1.25L美汁源果粒橙","shopPrice":9,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201602/thumb_img/252_thumb_G_1456450660879.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":285,"goodsName":"LOTTE乐天 韩国原装进口 牛奶碳酸饮料 250ml","shopPrice":5,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201603/thumb_img/285_thumb_G_1457590792869.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":119,"goodsName":"艾生活 真皮床双人床 独特围边 精细做工 卧室家具","shopPrice":3260,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/119_thumb_G_1437525155564.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":283,"goodsName":"好事达家用梯子四步梯加厚梯子折叠梯移动扶梯人字梯2766","shopPrice":2,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201603/thumb_img/_thumb_P_1457590880591.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":206,"goodsName":"洛斐（Lofree）创意无线蓝牙音箱音响 电脑音箱 EDGE锋芒3C建筑美学","shopPrice":249,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/206_thumb_G_1437535425884.jpg","catId":0,"promotePrice":199,"isPromote":1,"isHot":0}]}]
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

    public Object getIsOver() {
        return isOver;
    }

    public void setIsOver(Object isOver) {
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
         * itemType : goodsindex
         * module : goodsindex
         * itemList : [{"goodsId":216,"goodsName":"哈罗闪sanosan婴儿洗发露沐浴乳二合一","shopPrice":26,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/216_thumb_G_1437585478147.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":270,"goodsName":"五粮液 45度小酒版 水晶礼盒装 浓香型白酒 官方授权 酒厂直供 中国名酒 250ML","shopPrice":278,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201602/thumb_img/270_thumb_G_1456452662995.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":202,"goodsName":"安索夫迷你电脑USB2.0小音箱可爱熊猫便携笔记本台式电脑音箱 音响","shopPrice":29,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/202_thumb_G_1437534795824.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":41,"goodsName":"小金蛋女宝宝皮鞋夏真皮女童秋鞋公主鞋","shopPrice":99,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/41_thumb_G_1437515470354.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":203,"goodsName":"PowerCube魔方插座接线板 创意多功能荷兰Allocacoc模方插座 办公神器 USB款/无延长线直插(蓝)","shopPrice":49,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/203_thumb_G_1437534951257.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":252,"goodsName":"1.25L雪碧+1.25L美汁源果粒橙","shopPrice":9,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201602/thumb_img/252_thumb_G_1456450660879.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":285,"goodsName":"LOTTE乐天 韩国原装进口 牛奶碳酸饮料 250ml","shopPrice":5,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201603/thumb_img/285_thumb_G_1457590792869.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":119,"goodsName":"艾生活 真皮床双人床 独特围边 精细做工 卧室家具","shopPrice":3260,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/119_thumb_G_1437525155564.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":283,"goodsName":"好事达家用梯子四步梯加厚梯子折叠梯移动扶梯人字梯2766","shopPrice":2,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201603/thumb_img/_thumb_P_1457590880591.jpg","catId":0,"promotePrice":0,"isPromote":0,"isHot":1},{"goodsId":206,"goodsName":"洛斐（Lofree）创意无线蓝牙音箱音响 电脑音箱 EDGE锋芒3C建筑美学","shopPrice":249,"goodsThumb":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/206_thumb_G_1437535425884.jpg","catId":0,"promotePrice":199,"isPromote":1,"isHot":0}]
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
             * goodsId : 216
             * goodsName : 哈罗闪sanosan婴儿洗发露沐浴乳二合一
             * shopPrice : 26
             * goodsThumb : 49.122.47.185:8080/XJD/data/images/201507/thumb_img/216_thumb_G_1437585478147.jpg
             * catId : 0
             * promotePrice : 0
             * isPromote : 0
             * isHot : 1
             */

            public int goodsId;
            public String goodsName;
            public int shopPrice;
            public String goodsThumb;
            public int catId;
            public int promotePrice;
            public int isPromote;
            public int isHot;

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
        }
    }
}
