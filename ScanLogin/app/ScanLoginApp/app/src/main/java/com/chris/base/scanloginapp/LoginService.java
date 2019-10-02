package com.chris.base.scanloginapp;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * create by Chris Chan
 * create on 2019/10/2 16:45
 * use for :
 */
public interface LoginService {
    //获取笑话数据
    @GET("api/user/login")
    Call<Boolean> login(@QueryMap Map<String, Object> map);
}
