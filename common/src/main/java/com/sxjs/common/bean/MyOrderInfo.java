package com.sxjs.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class MyOrderInfo {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : null
     * timstamp : 1500448538484
     * pageindex : 0
     * items : [{"itemType":"orderInfo","module":"orderInfo","itemList":[{"orderId":184,"orderSn":"2017071127428","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":null,"province":null,"city":null,"district":null,"address":"1","zipcode":"","tel":null,"mobile":"11111111111","email":"","bestTime":null,"postscript":null,"payId":1,"payName":"支付宝","goodsAmount":997,"moneyPaid":0,"orderAmount":997,"addTime":"2017-07-11","payTime":"2017-07-11","confirmTime":"2017-07-11","shippingTime":null,"shippingTimeEnd":"2017-07-11","toBuyer":null,"payNote":null,"supplierId":0,"froms":null},{"orderId":185,"orderSn":"2017071347558","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":null,"province":null,"city":null,"district":null,"address":"1","zipcode":"","tel":null,"mobile":"11111111111","email":"","bestTime":null,"postscript":null,"payId":1,"payName":"支付宝","goodsAmount":133,"moneyPaid":0,"orderAmount":133,"addTime":"2017-07-13","payTime":"2017-07-13","confirmTime":"2017-07-13","shippingTime":null,"shippingTimeEnd":"2017-07-13","toBuyer":null,"payNote":null,"supplierId":0,"froms":null},{"orderId":186,"orderSn":"2017071794390","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":null,"province":null,"city":null,"district":null,"address":"1","zipcode":"","tel":null,"mobile":"11111111111","email":"","bestTime":null,"postscript":null,"payId":1,"payName":"支付宝","goodsAmount":4888,"moneyPaid":0,"orderAmount":4888,"addTime":"2017-07-17","payTime":"2017-07-17","confirmTime":"2017-07-17","shippingTime":null,"shippingTimeEnd":"2017-07-17","toBuyer":null,"payNote":null,"supplierId":0,"froms":null},{"orderId":187,"orderSn":"2017071794191","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":null,"province":null,"city":null,"district":null,"address":"1","zipcode":"","tel":null,"mobile":"11111111111","email":"","bestTime":null,"postscript":null,"payId":1,"payName":"支付宝","goodsAmount":5162,"moneyPaid":0,"orderAmount":5162,"addTime":"2017-07-17","payTime":"2017-07-17","confirmTime":"2017-07-17","shippingTime":null,"shippingTimeEnd":"2017-07-17","toBuyer":null,"payNote":null,"supplierId":0,"froms":null}]}]
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
         * itemType : orderInfo
         * module : orderInfo
         * itemList : [{"orderId":184,"orderSn":"2017071127428","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":null,"province":null,"city":null,"district":null,"address":"1","zipcode":"","tel":null,"mobile":"11111111111","email":"","bestTime":null,"postscript":null,"payId":1,"payName":"支付宝","goodsAmount":997,"moneyPaid":0,"orderAmount":997,"addTime":"2017-07-11","payTime":"2017-07-11","confirmTime":"2017-07-11","shippingTime":null,"shippingTimeEnd":"2017-07-11","toBuyer":null,"payNote":null,"supplierId":0,"froms":null},{"orderId":185,"orderSn":"2017071347558","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":null,"province":null,"city":null,"district":null,"address":"1","zipcode":"","tel":null,"mobile":"11111111111","email":"","bestTime":null,"postscript":null,"payId":1,"payName":"支付宝","goodsAmount":133,"moneyPaid":0,"orderAmount":133,"addTime":"2017-07-13","payTime":"2017-07-13","confirmTime":"2017-07-13","shippingTime":null,"shippingTimeEnd":"2017-07-13","toBuyer":null,"payNote":null,"supplierId":0,"froms":null},{"orderId":186,"orderSn":"2017071794390","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":null,"province":null,"city":null,"district":null,"address":"1","zipcode":"","tel":null,"mobile":"11111111111","email":"","bestTime":null,"postscript":null,"payId":1,"payName":"支付宝","goodsAmount":4888,"moneyPaid":0,"orderAmount":4888,"addTime":"2017-07-17","payTime":"2017-07-17","confirmTime":"2017-07-17","shippingTime":null,"shippingTimeEnd":"2017-07-17","toBuyer":null,"payNote":null,"supplierId":0,"froms":null},{"orderId":187,"orderSn":"2017071794191","userId":7,"orderStatus":1,"shippingStatus":0,"payStatus":0,"consignee":"11","country":null,"province":null,"city":null,"district":null,"address":"1","zipcode":"","tel":null,"mobile":"11111111111","email":"","bestTime":null,"postscript":null,"payId":1,"payName":"支付宝","goodsAmount":5162,"moneyPaid":0,"orderAmount":5162,"addTime":"2017-07-17","payTime":"2017-07-17","confirmTime":"2017-07-17","shippingTime":null,"shippingTimeEnd":"2017-07-17","toBuyer":null,"payNote":null,"supplierId":0,"froms":null}]
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
             * orderId : 184
             * orderSn : 2017071127428
             * userId : 7
             * orderStatus : 1
             * shippingStatus : 0
             * payStatus : 0
             * consignee : 11
             * country : null
             * province : null
             * city : null
             * district : null
             * address : 1
             * zipcode :
             * tel : null
             * mobile : 11111111111
             * email :
             * bestTime : null
             * postscript : null
             * payId : 1
             * payName : 支付宝
             * goodsAmount : 997
             * moneyPaid : 0
             * orderAmount : 997
             * addTime : 2017-07-11
             * payTime : 2017-07-11
             * confirmTime : 2017-07-11
             * shippingTime : null
             * shippingTimeEnd : 2017-07-11
             * toBuyer : null
             * payNote : null
             * supplierId : 0
             * froms : null
             */

            public int orderId;
            public String orderSn;
            public int userId;
            public int orderStatus;
            public int shippingStatus;
            public int payStatus;
            public String consignee;
            public Object country;
            public Object province;
            public Object city;
            public Object district;
            public String address;
            public String zipcode;
            public Object tel;
            public String mobile;
            public String email;
            public Object bestTime;
            public Object postscript;
            public int payId;
            public String payName;
            public int goodsAmount;
            public int moneyPaid;
            public int orderAmount;
            public String addTime;
            public String payTime;
            public String confirmTime;
            public Object shippingTime;
            public String shippingTimeEnd;
            public Object toBuyer;
            public Object payNote;
            public int supplierId;
            public Object froms;

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

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getDistrict() {
                return district;
            }

            public void setDistrict(Object district) {
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

            public Object getTel() {
                return tel;
            }

            public void setTel(Object tel) {
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

            public Object getBestTime() {
                return bestTime;
            }

            public void setBestTime(Object bestTime) {
                this.bestTime = bestTime;
            }

            public Object getPostscript() {
                return postscript;
            }

            public void setPostscript(Object postscript) {
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

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public String getPayTime() {
                return payTime;
            }

            public void setPayTime(String payTime) {
                this.payTime = payTime;
            }

            public String getConfirmTime() {
                return confirmTime;
            }

            public void setConfirmTime(String confirmTime) {
                this.confirmTime = confirmTime;
            }

            public Object getShippingTime() {
                return shippingTime;
            }

            public void setShippingTime(Object shippingTime) {
                this.shippingTime = shippingTime;
            }

            public String getShippingTimeEnd() {
                return shippingTimeEnd;
            }

            public void setShippingTimeEnd(String shippingTimeEnd) {
                this.shippingTimeEnd = shippingTimeEnd;
            }

            public Object getToBuyer() {
                return toBuyer;
            }

            public void setToBuyer(Object toBuyer) {
                this.toBuyer = toBuyer;
            }

            public Object getPayNote() {
                return payNote;
            }

            public void setPayNote(Object payNote) {
                this.payNote = payNote;
            }

            public int getSupplierId() {
                return supplierId;
            }

            public void setSupplierId(int supplierId) {
                this.supplierId = supplierId;
            }

            public Object getFroms() {
                return froms;
            }

            public void setFroms(Object froms) {
                this.froms = froms;
            }
        }
    }
}
