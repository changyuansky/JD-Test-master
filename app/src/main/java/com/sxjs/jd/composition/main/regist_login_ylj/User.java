package com.sxjs.jd.composition.main.regist_login_ylj;

import com.sxjs.common.bean.UserInfo;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class User extends UserInfo {
    String iphoneNumber;
    String password;
    String code;
    public User(String iphoneNumber,String password){
        this.iphoneNumber=iphoneNumber;
        this.password=password;
    }

    public User(String iphoneNumber, String password, String code) {
        this.iphoneNumber = iphoneNumber;
        this.password = password;
        this.code = code;
    }

    public String getIphoneNumber() {
        return iphoneNumber;
    }

    public void setIphoneNumber(String iphoneNumber) {
        this.iphoneNumber = iphoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
