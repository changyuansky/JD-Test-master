package com.sxjs.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class UserInfo {

    /**
     * code : 500
     * msg : 更新失败
     * isOver : null
     * timstamp : 1500556505271
     * pageindex : 0
     * items : [{"user_id":null,"email":null,"user_name":null,"password":null,"sex":null,"birthday":null,"address_id":null,"reg_time":null,"last_login":null,"last_time":null,"last_ip":null,"salt":null,"alias":null,"qq":null,"mobile_phone":null,"passwd_question":null,"passwd_answer":null,"country":null,"province":null,"city":null,"district":null,"address":null,"status":null,"froms":null,"headimg":null,"vcode":null}]
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
         * user_id : null
         * email : null
         * user_name : null
         * password : null
         * sex : null
         * birthday : null
         * address_id : null
         * reg_time : null
         * last_login : null
         * last_time : null
         * last_ip : null
         * salt : null
         * alias : null
         * qq : null
         * mobile_phone : null
         * passwd_question : null
         * passwd_answer : null
         * country : null
         * province : null
         * city : null
         * district : null
         * address : null
         * status : null
         * froms : null
         * headimg : null
         * vcode : null
         */

        public String user_id;
        public String email;
        public String user_name;
        public String password;
        public String sex;
        public String birthday;
        public String address_id;
        public String reg_time;
        public String last_login;
        public String last_time;
        public String last_ip;
        public String salt;
        public String alias;
        public String qq;
        public String mobile_phone;
        public String passwd_question;
        public String passwd_answer;
        public String country;
        public String province;
        public String city;
        public String district;
        public String address;
        public String status;
        public String froms;
        public String headimg;
        public String vcode;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress_id() {
            return address_id;
        }

        public void setAddress_id(String address_id) {
            this.address_id = address_id;
        }

        public String getReg_time() {
            return reg_time;
        }

        public void setReg_time(String reg_time) {
            this.reg_time = reg_time;
        }

        public String getLast_login() {
            return last_login;
        }

        public void setLast_login(String last_login) {
            this.last_login = last_login;
        }

        public String getLast_time() {
            return last_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
        }

        public String getLast_ip() {
            return last_ip;
        }

        public void setLast_ip(String last_ip) {
            this.last_ip = last_ip;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getMobile_phone() {
            return mobile_phone;
        }

        public void setMobile_phone(String mobile_phone) {
            this.mobile_phone = mobile_phone;
        }

        public String getPasswd_question() {
            return passwd_question;
        }

        public void setPasswd_question(String passwd_question) {
            this.passwd_question = passwd_question;
        }

        public String getPasswd_answer() {
            return passwd_answer;
        }

        public void setPasswd_answer(String passwd_answer) {
            this.passwd_answer = passwd_answer;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFroms() {
            return froms;
        }

        public void setFroms(String froms) {
            this.froms = froms;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getVcode() {
            return vcode;
        }

        public void setVcode(String vcode) {
            this.vcode = vcode;
        }
    }
}
