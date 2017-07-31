package com.sxjs.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */

public class Address {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : null
     * timstamp : 1501224631865
     * pageindex : 0
     * items : [{"itemType":"userAddress","module":"userAddress","itemList":[{"addressId":62,"addressName":"","userId":7,"consignee":"11","email":"","country":1,"province":2,"city":52,"district":500,"address":"北京省北京市东城区东盛校区3-206","zipcode":"","tel":"-","mobile":"11111111111","bestTime":""}]}]
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
         * itemType : userAddress
         * module : userAddress
         * itemList : [{"addressId":62,"addressName":"","userId":7,"consignee":"11","email":"","country":1,"province":2,"city":52,"district":500,"address":"北京省北京市东城区东盛校区3-206","zipcode":"","tel":"-","mobile":"11111111111","bestTime":""}]
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
             * addressId : 62
             * addressName :
             * userId : 7
             * consignee : 11
             * email :
             * country : 1
             * province : 2
             * city : 52
             * district : 500
             * address : 北京省北京市东城区东盛校区3-206
             * zipcode :
             * tel : -
             * mobile : 11111111111
             * bestTime :
             */

            public int addressId;
            public String addressName;
            public int userId;
            public String consignee;
            public String email;
            public int country;
            public int province;
            public int city;
            public int district;
            public String address;
            public String zipcode;
            public String tel;
            public String mobile;
            public String bestTime;

            public int getAddressId() {
                return addressId;
            }

            public void setAddressId(int addressId) {
                this.addressId = addressId;
            }

            public String getAddressName() {
                return addressName;
            }

            public void setAddressName(String addressName) {
                this.addressName = addressName;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
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

            public String getBestTime() {
                return bestTime;
            }

            public void setBestTime(String bestTime) {
                this.bestTime = bestTime;
            }
        }
    }
}
