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
     * timstamp : 1500699540707
     * pageindex : 0
     * items : [{"itemType":"ordergoodsInfo_List","module":"ordergoodsInfo","itemList":[{"orderInfos":[{"order_id":187,"order_sn":"2017071794191","user_id":7,"order_status":1,"shipping_status":0,"pay_status":0,"consignee":"11","country":"1","province":"2","city":"52","district":"500","address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","best_time":"仅工作日送货","postscript":"","pay_id":1,"pay_name":"支付宝","goods_amount":5162,"money_paid":0,"order_amount":5162,"add_time":1500281249000,"pay_time":1500281249000,"confirm_time":1500281249000,"shipping_time":1500281249000,"shipping_time_end":1500281249000,"to_buyer":"","pay_note":"","supplier_id":0,"froms":"pc","supplierName":"商城自营"}],"orderGoods":[{"rec_id":239,"order_id":187,"goods_id":100,"goods_name":"苹果（Apple）iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机","goods_sn":"ECS000100","goods_number":1,"market_price":5000,"goods_price":4888,"product_id":27,"goods_attr":"颜色:白色","comment_state":0,"is_back":0,"costPrice":0,"cost_price":4888,"promote_price":"0.00","goods_img":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/100_thumb_G_1437523484060.jpg"},{"rec_id":240,"order_id":187,"goods_id":232,"goods_name":"包邮 新款户外军迷阿帕奇T恤 纯棉男款短袖半袖特价宽松","goods_sn":"ECS000232","goods_number":1,"market_price":328,"goods_price":274,"product_id":0,"goods_attr":"","comment_state":0,"is_back":0,"costPrice":0,"cost_price":274,"promote_price":"199.00","goods_img":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/_thumb_P_1438047501681.jpg"}]}]}]
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
         * itemType : ordergoodsInfo_List
         * module : ordergoodsInfo
         * itemList : [{"orderInfos":[{"order_id":187,"order_sn":"2017071794191","user_id":7,"order_status":1,"shipping_status":0,"pay_status":0,"consignee":"11","country":"1","province":"2","city":"52","district":"500","address":"1","zipcode":"","tel":"-","mobile":"11111111111","email":"","best_time":"仅工作日送货","postscript":"","pay_id":1,"pay_name":"支付宝","goods_amount":5162,"money_paid":0,"order_amount":5162,"add_time":1500281249000,"pay_time":1500281249000,"confirm_time":1500281249000,"shipping_time":1500281249000,"shipping_time_end":1500281249000,"to_buyer":"","pay_note":"","supplier_id":0,"froms":"pc","supplierName":"商城自营"}],"orderGoods":[{"rec_id":239,"order_id":187,"goods_id":100,"goods_name":"苹果（Apple）iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机","goods_sn":"ECS000100","goods_number":1,"market_price":5000,"goods_price":4888,"product_id":27,"goods_attr":"颜色:白色","comment_state":0,"is_back":0,"costPrice":0,"cost_price":4888,"promote_price":"0.00","goods_img":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/100_thumb_G_1437523484060.jpg"},{"rec_id":240,"order_id":187,"goods_id":232,"goods_name":"包邮 新款户外军迷阿帕奇T恤 纯棉男款短袖半袖特价宽松","goods_sn":"ECS000232","goods_number":1,"market_price":328,"goods_price":274,"product_id":0,"goods_attr":"","comment_state":0,"is_back":0,"costPrice":0,"cost_price":274,"promote_price":"199.00","goods_img":"49.122.47.185:8080/XJD/data/images/201507/thumb_img/_thumb_P_1438047501681.jpg"}]}]
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
                 * order_id : 187
                 * order_sn : 2017071794191
                 * user_id : 7
                 * order_status : 1
                 * shipping_status : 0
                 * pay_status : 0
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
                 * best_time : 仅工作日送货
                 * postscript :
                 * pay_id : 1
                 * pay_name : 支付宝
                 * goods_amount : 5162
                 * money_paid : 0
                 * order_amount : 5162
                 * add_time : 1500281249000
                 * pay_time : 1500281249000
                 * confirm_time : 1500281249000
                 * shipping_time : 1500281249000
                 * shipping_time_end : 1500281249000
                 * to_buyer :
                 * pay_note :
                 * supplier_id : 0
                 * froms : pc
                 * supplierName : 商城自营
                 */

                public int order_id;
                public String order_sn;
                public int user_id;
                public int order_status;
                public int shipping_status;
                public int pay_status;
                public String consignee;
                public String country;
                public String province;
                public String city;
                public String district;
                public String address;
                public String zipcode;
                public String tel;
                public String mobile;
                public String email;
                public String best_time;
                public String postscript;
                public int pay_id;
                public String pay_name;
                public int goods_amount;
                public int money_paid;
                public int order_amount;
                public long add_time;
                public long pay_time;
                public long confirm_time;
                public long shipping_time;
                public long shipping_time_end;
                public String to_buyer;
                public String pay_note;
                public int supplier_id;
                public String froms;
                public String supplierName;

                public int getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(int order_id) {
                    this.order_id = order_id;
                }

                public String getOrder_sn() {
                    return order_sn;
                }

                public void setOrder_sn(String order_sn) {
                    this.order_sn = order_sn;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getOrder_status() {
                    return order_status;
                }

                public void setOrder_status(int order_status) {
                    this.order_status = order_status;
                }

                public int getShipping_status() {
                    return shipping_status;
                }

                public void setShipping_status(int shipping_status) {
                    this.shipping_status = shipping_status;
                }

                public int getPay_status() {
                    return pay_status;
                }

                public void setPay_status(int pay_status) {
                    this.pay_status = pay_status;
                }

                public String getConsignee() {
                    return consignee;
                }

                public void setConsignee(String consignee) {
                    this.consignee = consignee;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
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

                public String getBest_time() {
                    return best_time;
                }

                public void setBest_time(String best_time) {
                    this.best_time = best_time;
                }

                public String getPostscript() {
                    return postscript;
                }

                public void setPostscript(String postscript) {
                    this.postscript = postscript;
                }

                public int getPay_id() {
                    return pay_id;
                }

                public void setPay_id(int pay_id) {
                    this.pay_id = pay_id;
                }

                public String getPay_name() {
                    return pay_name;
                }

                public void setPay_name(String pay_name) {
                    this.pay_name = pay_name;
                }

                public int getGoods_amount() {
                    return goods_amount;
                }

                public void setGoods_amount(int goods_amount) {
                    this.goods_amount = goods_amount;
                }

                public int getMoney_paid() {
                    return money_paid;
                }

                public void setMoney_paid(int money_paid) {
                    this.money_paid = money_paid;
                }

                public int getOrder_amount() {
                    return order_amount;
                }

                public void setOrder_amount(int order_amount) {
                    this.order_amount = order_amount;
                }

                public long getAdd_time() {
                    return add_time;
                }

                public void setAdd_time(long add_time) {
                    this.add_time = add_time;
                }

                public long getPay_time() {
                    return pay_time;
                }

                public void setPay_time(long pay_time) {
                    this.pay_time = pay_time;
                }

                public long getConfirm_time() {
                    return confirm_time;
                }

                public void setConfirm_time(long confirm_time) {
                    this.confirm_time = confirm_time;
                }

                public long getShipping_time() {
                    return shipping_time;
                }

                public void setShipping_time(long shipping_time) {
                    this.shipping_time = shipping_time;
                }

                public long getShipping_time_end() {
                    return shipping_time_end;
                }

                public void setShipping_time_end(long shipping_time_end) {
                    this.shipping_time_end = shipping_time_end;
                }

                public String getTo_buyer() {
                    return to_buyer;
                }

                public void setTo_buyer(String to_buyer) {
                    this.to_buyer = to_buyer;
                }

                public String getPay_note() {
                    return pay_note;
                }

                public void setPay_note(String pay_note) {
                    this.pay_note = pay_note;
                }

                public int getSupplier_id() {
                    return supplier_id;
                }

                public void setSupplier_id(int supplier_id) {
                    this.supplier_id = supplier_id;
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
                 * rec_id : 239
                 * order_id : 187
                 * goods_id : 100
                 * goods_name : 苹果（Apple）iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机
                 * goods_sn : ECS000100
                 * goods_number : 1
                 * market_price : 5000
                 * goods_price : 4888
                 * product_id : 27
                 * goods_attr : 颜色:白色
                 * comment_state : 0
                 * is_back : 0
                 * costPrice : 0
                 * cost_price : 4888
                 * promote_price : 0.00
                 * goods_img : 49.122.47.185:8080/XJD/data/images/201507/thumb_img/100_thumb_G_1437523484060.jpg
                 */

                public int rec_id;
                public int order_id;
                public int goods_id;
                public String goods_name;
                public String goods_sn;
                public int goods_number;
                public int market_price;
                public int goods_price;
                public int product_id;
                public String goods_attr;
                public int comment_state;
                public int is_back;
                public int costPrice;
                public int cost_price;
                public String promote_price;
                public String goods_img;

                public int getRec_id() {
                    return rec_id;
                }

                public void setRec_id(int rec_id) {
                    this.rec_id = rec_id;
                }

                public int getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(int order_id) {
                    this.order_id = order_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public String getGoods_sn() {
                    return goods_sn;
                }

                public void setGoods_sn(String goods_sn) {
                    this.goods_sn = goods_sn;
                }

                public int getGoods_number() {
                    return goods_number;
                }

                public void setGoods_number(int goods_number) {
                    this.goods_number = goods_number;
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

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public String getGoods_attr() {
                    return goods_attr;
                }

                public void setGoods_attr(String goods_attr) {
                    this.goods_attr = goods_attr;
                }

                public int getComment_state() {
                    return comment_state;
                }

                public void setComment_state(int comment_state) {
                    this.comment_state = comment_state;
                }

                public int getIs_back() {
                    return is_back;
                }

                public void setIs_back(int is_back) {
                    this.is_back = is_back;
                }

                public int getCostPrice() {
                    return costPrice;
                }

                public void setCostPrice(int costPrice) {
                    this.costPrice = costPrice;
                }

                public int getCost_price() {
                    return cost_price;
                }

                public void setCost_price(int cost_price) {
                    this.cost_price = cost_price;
                }

                public String getPromote_price() {
                    return promote_price;
                }

                public void setPromote_price(String promote_price) {
                    this.promote_price = promote_price;
                }

                public String getGoods_img() {
                    return goods_img;
                }

                public void setGoods_img(String goods_img) {
                    this.goods_img = goods_img;
                }
            }
        }
    }
}
