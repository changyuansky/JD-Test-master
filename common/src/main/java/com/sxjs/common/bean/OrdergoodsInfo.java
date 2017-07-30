package com.sxjs.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */

public class OrdergoodsInfo {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : null
     * timstamp : 1501232063932
     * pageindex : 0
     * items : [{"itemType":"ordergoodsInfo_List","module":"ordergoodsInfo","itemList":[{"orderInfos":[{"orderId":192,"orderSn":"2017072040318","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":2,"city":52,"district":500,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":5398,"moneyPaid":0,"orderAmount":5398,"addTime":1500517076000,"payTime":1500517076000,"confirmTime":1500517076000,"shippingTime":1500517076000,"shippingTimeEnd":1500517076000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商家自营"}],"orderGoods":[{"recId":243,"orderId":192,"goodsId":292,"goodsName":"一加手机3T (A3010) 6GB+64GB 枪灰版 全网通 双卡双待 移动联通电信4G手机","goodsSn":"EN1232133600","goodsNumber":1,"marketPrice":3333.13,"goodsPrice":2399,"productId":0,"goodsAttrId":"","commentState":0,"isBack":0,"costPrice":2399,"promotePrice":1111,"goodsAttr":"","goodsImg":"10.10.140.231:81/shop/data/images/20170529/58343dc1Nbb3d4722.jpg"},{"recId":244,"orderId":192,"goodsId":223,"goodsName":"乐和居 双人床 床 榻榻米床 头层真皮","goodsSn":"ECS000223","goodsNumber":1,"marketPrice":3598.79,"goodsPrice":2999,"productId":0,"goodsAttrId":"","commentState":0,"isBack":0,"costPrice":2999,"promotePrice":0,"goodsAttr":"","goodsImg":"10.10.140.231:81/shop/data/images/201507/thumb_img/223_thumb_G_1437586798114.jpg"}]}]}]
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
         * itemType : ordergoodsInfo_List
         * module : ordergoodsInfo
         * itemList : [{"orderInfos":[{"orderId":192,"orderSn":"2017072040318","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":2,"city":52,"district":500,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":5398,"moneyPaid":0,"orderAmount":5398,"addTime":1500517076000,"payTime":1500517076000,"confirmTime":1500517076000,"shippingTime":1500517076000,"shippingTimeEnd":1500517076000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商家自营"}],"orderGoods":[{"recId":243,"orderId":192,"goodsId":292,"goodsName":"一加手机3T (A3010) 6GB+64GB 枪灰版 全网通 双卡双待 移动联通电信4G手机","goodsSn":"EN1232133600","goodsNumber":1,"marketPrice":3333.13,"goodsPrice":2399,"productId":0,"goodsAttrId":"","commentState":0,"isBack":0,"costPrice":2399,"promotePrice":1111,"goodsAttr":"","goodsImg":"10.10.140.231:81/shop/data/images/20170529/58343dc1Nbb3d4722.jpg"},{"recId":244,"orderId":192,"goodsId":223,"goodsName":"乐和居 双人床 床 榻榻米床 头层真皮","goodsSn":"ECS000223","goodsNumber":1,"marketPrice":3598.79,"goodsPrice":2999,"productId":0,"goodsAttrId":"","commentState":0,"isBack":0,"costPrice":2999,"promotePrice":0,"goodsAttr":"","goodsImg":"10.10.140.231:81/shop/data/images/201507/thumb_img/223_thumb_G_1437586798114.jpg"}]}]
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
            public List<OrderInfosBean> orderInfos;
            public List<OrderGoodsBean> orderGoods;

            public List<OrderInfosBean> getOrderInfos() {
                return orderInfos;
            }

            public void setOrderInfos(List<OrderInfosBean> orderInfos) {
                this.orderInfos = orderInfos;
            }

            public List<OrderGoodsBean> getOrderGoods() {
                return orderGoods;
            }

            public void setOrderGoods(List<OrderGoodsBean> orderGoods) {
                this.orderGoods = orderGoods;
            }

            public static class OrderInfosBean {
                /**
                 * orderId : 192
                 * orderSn : 2017072040318
                 * userId : 7
                 * orderStatus : 1
                 * shippingStatus : 0
                 * payStatus : 0
                 * consignee : 11
                 * country : 1
                 * province : 2
                 * city : 52
                 * district : 500
                 * address : 1
                 * zipcode :
                 * tel : -
                 * mobile : 11111111111
                 * email :
                 * bestTime : 仅工作日送货
                 * postscript :
                 * payId : 1
                 * payName : 支付宝
                 * goodsAmount : 5398
                 * moneyPaid : 0
                 * orderAmount : 5398
                 * addTime : 1500517076000
                 * payTime : 1500517076000
                 * confirmTime : 1500517076000
                 * shippingTime : 1500517076000
                 * shippingTimeEnd : 1500517076000
                 * toBuyer :
                 * payNote :
                 * supplierId : 0
                 * froms : pc
                 * supplierName : 商家自营
                 */

                public int orderId;
                public String orderSn;
                public int userId;
                public int orderStatus;
                public int shippingStatus;
                public int payStatus;
                public String consignee;
                public int country;
                public int province;
                public int city;
                public int district;
                public String address;
                public String zipcode;
                public String tel;
                public String mobile;
                public String email;
                public String bestTime;
                public String postscript;
                public int payId;
                public String payName;
                public int goodsAmount;
                public int moneyPaid;
                public int orderAmount;
                public long addTime;
                public long payTime;
                public long confirmTime;
                public long shippingTime;
                public long shippingTimeEnd;
                public String toBuyer;
                public String payNote;
                public int supplierId;
                public String froms;
                public String supplierName;

                public int getOrderId() {
                    return orderId;
                }

                public void setOrderId(int orderId) {
                    this.orderId = orderId;
                }

                public String getOrderSn() {
                    return orderSn;
                }

                public void setOrderSn(String orderSn) {
                    this.orderSn = orderSn;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public int getOrderStatus() {
                    return orderStatus;
                }

                public void setOrderStatus(int orderStatus) {
                    this.orderStatus = orderStatus;
                }

                public int getShippingStatus() {
                    return shippingStatus;
                }

                public void setShippingStatus(int shippingStatus) {
                    this.shippingStatus = shippingStatus;
                }

                public int getPayStatus() {
                    return payStatus;
                }

                public void setPayStatus(int payStatus) {
                    this.payStatus = payStatus;
                }

                public String getConsignee() {
                    return consignee;
                }

                public void setConsignee(String consignee) {
                    this.consignee = consignee;
                }

                public int getCountry() {
                    return country;
                }

                public void setCountry(int country) {
                    this.country = country;
                }

                public int getProvince() {
                    return province;
                }

                public void setProvince(int province) {
                    this.province = province;
                }

                public int getCity() {
                    return city;
                }

                public void setCity(int city) {
                    this.city = city;
                }

                public int getDistrict() {
                    return district;
                }

                public void setDistrict(int district) {
                    this.district = district;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getZipcode() {
                    return zipcode;
                }

                public void setZipcode(String zipcode) {
                    this.zipcode = zipcode;
                }

                public String getTel() {
                    return tel;
                }

                public void setTel(String tel) {
                    this.tel = tel;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getBestTime() {
                    return bestTime;
                }

                public void setBestTime(String bestTime) {
                    this.bestTime = bestTime;
                }

                public String getPostscript() {
                    return postscript;
                }

                public void setPostscript(String postscript) {
                    this.postscript = postscript;
                }

                public int getPayId() {
                    return payId;
                }

                public void setPayId(int payId) {
                    this.payId = payId;
                }

                public String getPayName() {
                    return payName;
                }

                public void setPayName(String payName) {
                    this.payName = payName;
                }

                public int getGoodsAmount() {
                    return goodsAmount;
                }

                public void setGoodsAmount(int goodsAmount) {
                    this.goodsAmount = goodsAmount;
                }

                public int getMoneyPaid() {
                    return moneyPaid;
                }

                public void setMoneyPaid(int moneyPaid) {
                    this.moneyPaid = moneyPaid;
                }

                public int getOrderAmount() {
                    return orderAmount;
                }

                public void setOrderAmount(int orderAmount) {
                    this.orderAmount = orderAmount;
                }

                public long getAddTime() {
                    return addTime;
                }

                public void setAddTime(long addTime) {
                    this.addTime = addTime;
                }

                public long getPayTime() {
                    return payTime;
                }

                public void setPayTime(long payTime) {
                    this.payTime = payTime;
                }

                public long getConfirmTime() {
                    return confirmTime;
                }

                public void setConfirmTime(long confirmTime) {
                    this.confirmTime = confirmTime;
                }

                public long getShippingTime() {
                    return shippingTime;
                }

                public void setShippingTime(long shippingTime) {
                    this.shippingTime = shippingTime;
                }

                public long getShippingTimeEnd() {
                    return shippingTimeEnd;
                }

                public void setShippingTimeEnd(long shippingTimeEnd) {
                    this.shippingTimeEnd = shippingTimeEnd;
                }

                public String getToBuyer() {
                    return toBuyer;
                }

                public void setToBuyer(String toBuyer) {
                    this.toBuyer = toBuyer;
                }

                public String getPayNote() {
                    return payNote;
                }

                public void setPayNote(String payNote) {
                    this.payNote = payNote;
                }

                public int getSupplierId() {
                    return supplierId;
                }

                public void setSupplierId(int supplierId) {
                    this.supplierId = supplierId;
                }

                public String getFroms() {
                    return froms;
                }

                public void setFroms(String froms) {
                    this.froms = froms;
                }

                public String getSupplierName() {
                    return supplierName;
                }

                public void setSupplierName(String supplierName) {
                    this.supplierName = supplierName;
                }
            }

            public static class OrderGoodsBean {
                /**
                 * recId : 243
                 * orderId : 192
                 * goodsId : 292
                 * goodsName : 一加手机3T (A3010) 6GB+64GB 枪灰版 全网通 双卡双待 移动联通电信4G手机
                 * goodsSn : EN1232133600
                 * goodsNumber : 1
                 * marketPrice : 3333.13
                 * goodsPrice : 2399
                 * productId : 0
                 * goodsAttrId :
                 * commentState : 0
                 * isBack : 0
                 * costPrice : 2399
                 * promotePrice : 1111
                 * goodsAttr :
                 * goodsImg : 10.10.140.231:81/shop/data/images/20170529/58343dc1Nbb3d4722.jpg
                 */

                public int recId;
                public int orderId;
                public int goodsId;
                public String goodsName;
                public String goodsSn;
                public int goodsNumber;
                public double marketPrice;
                public int goodsPrice;
                public int productId;
                public String goodsAttrId;
                public int commentState;
                public int isBack;
                public int costPrice;
                public int promotePrice;
                public String goodsAttr;
                public String goodsImg;

                public int getRecId() {
                    return recId;
                }

                public void setRecId(int recId) {
                    this.recId = recId;
                }

                public int getOrderId() {
                    return orderId;
                }

                public void setOrderId(int orderId) {
                    this.orderId = orderId;
                }

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

                public String getGoodsSn() {
                    return goodsSn;
                }

                public void setGoodsSn(String goodsSn) {
                    this.goodsSn = goodsSn;
                }

                public int getGoodsNumber() {
                    return goodsNumber;
                }

                public void setGoodsNumber(int goodsNumber) {
                    this.goodsNumber = goodsNumber;
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

                public int getProductId() {
                    return productId;
                }

                public void setProductId(int productId) {
                    this.productId = productId;
                }

                public String getGoodsAttrId() {
                    return goodsAttrId;
                }

                public void setGoodsAttrId(String goodsAttrId) {
                    this.goodsAttrId = goodsAttrId;
                }

                public int getCommentState() {
                    return commentState;
                }

                public void setCommentState(int commentState) {
                    this.commentState = commentState;
                }

                public int getIsBack() {
                    return isBack;
                }

                public void setIsBack(int isBack) {
                    this.isBack = isBack;
                }

                public int getCostPrice() {
                    return costPrice;
                }

                public void setCostPrice(int costPrice) {
                    this.costPrice = costPrice;
                }

                public int getPromotePrice() {
                    return promotePrice;
                }

                public void setPromotePrice(int promotePrice) {
                    this.promotePrice = promotePrice;
                }

                public String getGoodsAttr() {
                    return goodsAttr;
                }

                public void setGoodsAttr(String goodsAttr) {
                    this.goodsAttr = goodsAttr;
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
}
