package com.sxjs.common.callback;

//OnResultCallBack——请求成功或失败的回调
public interface OnResultCallBack<T> {

    void onSuccess(T t);

    void onError(int code, String errorMsg);
}
