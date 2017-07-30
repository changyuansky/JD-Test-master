package com.sxjs.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class MyOrderInfo {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : 1
     * timstamp : 1501231784363
     * pageindex : 1
     * items : [{"itemType":"orderInfo","module":"orderInfo","itemList":[{"orderInfos":[{"orderId":204,"orderSn":"2017072593962","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500956195000,"payTime":1500956195000,"confirmTime":1500956195000,"shippingTime":1500956195000,"shippingTimeEnd":1500956195000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":203,"orderSn":"2017072583074","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500952103000,"payTime":1500952103000,"confirmTime":1500952103000,"shippingTime":1500952103000,"shippingTimeEnd":1500952103000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":202,"orderSn":"2017072578145","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500951980000,"payTime":1500951980000,"confirmTime":1500951980000,"shippingTime":1500951980000,"shippingTimeEnd":1500951980000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":201,"orderSn":"201707252394","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500950840000,"payTime":1500950840000,"confirmTime":1500950840000,"shippingTime":1500950840000,"shippingTimeEnd":1500950840000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":200,"orderSn":"2017072587348","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500950445000,"payTime":1500950445000,"confirmTime":1500950445000,"shippingTime":1500950445000,"shippingTimeEnd":1500950445000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":199,"orderSn":"201707253913","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":198,"moneyPaid":0,"orderAmount":198,"addTime":1500950279000,"payTime":1500950279000,"confirmTime":1500950279000,"shippingTime":1500950279000,"shippingTimeEnd":1500950279000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":198,"orderSn":"2017072555001","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":198,"moneyPaid":0,"orderAmount":198,"addTime":1500949665000,"payTime":1500949665000,"confirmTime":1500949665000,"shippingTime":1500949665000,"shippingTimeEnd":1500949665000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":197,"orderSn":"2017072546500","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":198,"moneyPaid":0,"orderAmount":198,"addTime":1500949528000,"payTime":1500949528000,"confirmTime":1500949528000,"shippingTime":1500949528000,"shippingTimeEnd":1500949528000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":196,"orderSn":"2017072555982","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":198,"moneyPaid":0,"orderAmount":198,"addTime":1500949404000,"payTime":1500949404000,"confirmTime":1500949404000,"shippingTime":1500949404000,"shippingTimeEnd":1500949404000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":195,"orderSn":"2017072468857","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500886910000,"payTime":1500886910000,"confirmTime":1500886910000,"shippingTime":1500886910000,"shippingTimeEnd":1500886910000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"}],"orderGoods":[{"recId":249,"orderId":195,"goodsId":114,"goodsName":"米酒机酸奶机全自动家用不锈钢正品包邮","goodsSn":"ECS000114","goodsNumber":1,"marketPrice":106.8,"goodsPrice":99,"productId":0,"goodsAttrId":"","commentState":0,"isBack":0,"costPrice":99,"promotePrice":99,"goodsAttr":"","goodsImg":"10.10.140.231:81/shop/data/images/201507/thumb_img/114_thumb_G_1437524086723.jpg"}]}]}]
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
         * itemType : orderInfo
         * module : orderInfo
         * itemList : [{"orderInfos":[{"orderId":204,"orderSn":"2017072593962","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500956195000,"payTime":1500956195000,"confirmTime":1500956195000,"shippingTime":1500956195000,"shippingTimeEnd":1500956195000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":203,"orderSn":"2017072583074","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500952103000,"payTime":1500952103000,"confirmTime":1500952103000,"shippingTime":1500952103000,"shippingTimeEnd":1500952103000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":202,"orderSn":"2017072578145","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500951980000,"payTime":1500951980000,"confirmTime":1500951980000,"shippingTime":1500951980000,"shippingTimeEnd":1500951980000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":201,"orderSn":"201707252394","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500950840000,"payTime":1500950840000,"confirmTime":1500950840000,"shippingTime":1500950840000,"shippingTimeEnd":1500950840000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":200,"orderSn":"2017072587348","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500950445000,"payTime":1500950445000,"confirmTime":1500950445000,"shippingTime":1500950445000,"shippingTimeEnd":1500950445000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":199,"orderSn":"201707253913","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":198,"moneyPaid":0,"orderAmount":198,"addTime":1500950279000,"payTime":1500950279000,"confirmTime":1500950279000,"shippingTime":1500950279000,"shippingTimeEnd":1500950279000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":198,"orderSn":"2017072555001","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":198,"moneyPaid":0,"orderAmount":198,"addTime":1500949665000,"payTime":1500949665000,"confirmTime":1500949665000,"shippingTime":1500949665000,"shippingTimeEnd":1500949665000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":197,"orderSn":"2017072546500","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":198,"moneyPaid":0,"orderAmount":198,"addTime":1500949528000,"payTime":1500949528000,"confirmTime":1500949528000,"shippingTime":1500949528000,"shippingTimeEnd":1500949528000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":196,"orderSn":"2017072555982","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":198,"moneyPaid":0,"orderAmount":198,"addTime":1500949404000,"payTime":1500949404000,"confirmTime":1500949404000,"shippingTime":1500949404000,"shippingTimeEnd":1500949404000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"},{"orderId":195,"orderSn":"2017072468857","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":1,"province":6,"city":79,"district":718,"address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","bestTime":"仅工作日送货","postscript":"","payId":1,"payName":"支付宝","goodsAmount":99,"moneyPaid":0,"orderAmount":99,"addTime":1500886910000,"payTime":1500886910000,"confirmTime":1500886910000,"shippingTime":1500886910000,"shippingTimeEnd":1500886910000,"toBuyer":"","payNote":"","supplierId":0,"froms":"pc","supplierName":"商城自营"}],"orderGoods":[{"recId":249,"orderId":195,"goodsId":114,"goodsName":"米酒机酸奶机全自动家用不锈钢正品包邮","goodsSn":"ECS000114","goodsNumber":1,"marketPrice":106.8,"goodsPrice":99,"productId":0,"goodsAttrId":"","commentState":0,"isBack":0,"costPrice":99,"promotePrice":99,"goodsAttr":"","goodsImg":"10.10.140.231:81/shop/data/images/201507/thumb_img/114_thumb_G_1437524086723.jpg"}]}]
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
                 * orderId : 204
                 * orderSn : 2017072593962
                 * userId : 7
                 * orderStatus : 1
                 * shippingStatus : 0
                 * payStatus : 0
                 * consignee : 11
                 * country : 1
                 * province : 6
                 * city : 79
                 * district : 718
                 * address : 1
                 * zipcode :
                 * tel : -
                 * mobile : 11111111111
                 * email :
                 * bestTime : 仅工作日送货
                 * postscript :
                 * payId : 1
                 * payName : 支付宝
                 * goodsAmount : 99
                 * moneyPaid : 0
                 * orderAmount : 99
                 * addTime : 1500956195000
                 * payTime : 1500956195000
                 * confirmTime : 1500956195000
                 * shippingTime : 1500956195000
                 * shippingTimeEnd : 1500956195000
                 * toBuyer :
                 * payNote :
                 * supplierId : 0
                 * froms : pc
                 * supplierName : 商城自营
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
                 * recId : 249
                 * orderId : 195
                 * goodsId : 114
                 * goodsName : 米酒机酸奶机全自动家用不锈钢正品包邮
                 * goodsSn : ECS000114
                 * goodsNumber : 1
                 * marketPrice : 106.8
                 * goodsPrice : 99
                 * productId : 0
                 * goodsAttrId :
                 * commentState : 0
                 * isBack : 0
                 * costPrice : 99
                 * promotePrice : 99
                 * goodsAttr :
                 * goodsImg : 10.10.140.231:81/shop/data/images/201507/thumb_img/114_thumb_G_1437524086723.jpg
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
