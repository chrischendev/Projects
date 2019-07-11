package com.chris.base.library.net;

import retrofit2.Call;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:15
 * use for :
 */
public class NetResponse<T> {
    public Call call;
    public boolean isSuccess;//是否请求成功
    public NetStatus status;//状态码
    public int code;//状态码
    public T data;//返回的数据主体

    public NetResponse() {
    }

    public NetResponse(Call call, boolean isSuccess, NetStatus status, T data) {
        this.call = call;
        this.isSuccess = isSuccess;
        this.status = status;
        this.data = data;
    }
}
