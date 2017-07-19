package com.sxjs.common.bean;

/**
 * Created by Administrator on 2017/7/17.
 */

public class UserInfo {

    /**
     * code : null
     * msg : null
     * isOver : null
     * timstamp : null
     * pageindex : 0
     * items : null
     */

    public String code;
    public String msg;
    public long timstamp;
    /*
        * `user_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
      `email` varchar(60) NOT NULL DEFAULT '' COMMENT '会员Email',
      `user_name` varchar(60) NOT NULL DEFAULT '' COMMENT '用户名',
      `password` varchar(32) NOT NULL DEFAULT '' COMMENT '用户密码',
      `sex` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '性别 ;  0保密;  1男; 2女',
      `birthday` date NOT NULL DEFAULT '0000-00-00' COMMENT '出生日期',
      `address_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '收货信息id,表值表user_address',
      `reg_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
      `last_login` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后一次登录时间',
      `last_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '应该是最后一次修改信息时间，该表信息从其他表同步过来考虑',
      `last_ip` varchar(15) NOT NULL DEFAULT '' COMMENT '最后一次登录IP',
      `salt` varchar(10) NOT NULL DEFAULT '0' COMMENT '盐',
      `alias` varchar(60) NOT NULL COMMENT '昵称',
      `qq` varchar(20) NOT NULL,
      `mobile_phone` varchar(20) NOT NULL COMMENT '移动电话',
      `passwd_question` varchar(50) DEFAULT NULL COMMENT '密保问题',
      `passwd_answer` varchar(255) DEFAULT NULL COMMENT '密保答案',
      `country` int(11) NOT NULL COMMENT '国家 取region表',
      `province` int(11) NOT NULL COMMENT '省份取region表',
      `city` int(11) NOT NULL COMMENT '城市取region表',
      `district` int(11) NOT NULL COMMENT '区域取region表',
      `address` varchar(255) NOT NULL DEFAULT '' COMMENT '详细地址',
      `status` int(11) NOT NULL COMMENT '审核状态 1通过 -1不通过 0审核中',
      `froms` char(10) NOT NULL DEFAULT 'pc' COMMENT 'pc:电脑,mobile:手机,app:应用',
      `headimg` varchar(255) NOT NULL COMMENT '头像',
      PRIMARY KEY (`user_id`),
      UNIQUE KEY `user_name` (`user_name`),
      KEY `email` (`email`)
        * */

        int user_id;
        int reg_time;
        int status;
        int district;
        int country;
        int province;
        int city;
        int address_id;
        int sex;
        String email;
        String user_name;
        String password;
        String birthday;
        String last_login;
        String last_time;
        String last_ip;
        String salt;
        String alias;
        String qq;
        String mobile_phone;
        String passwd_question;
        String address;
        String froms;
        String headimg;
        String vcode;

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

    public long getTimstamp() {
        return timstamp;
    }

    public void setTimstamp(long timstamp) {
        this.timstamp = timstamp;
    }

    public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getReg_time() {
            return reg_time;
        }

        public void setReg_time(int reg_time) {
            this.reg_time = reg_time;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getDistrict() {
            return district;
        }

        public void setDistrict(int district) {
            this.district = district;
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

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
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

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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
