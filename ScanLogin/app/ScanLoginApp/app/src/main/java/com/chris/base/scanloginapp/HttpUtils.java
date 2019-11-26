package com.chris.base.scanloginapp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * create by Chris Chan
 * create on 2019/10/2 16:44
 * use for :
 */
public class HttpUtils {
    /**
     * 登录
     * @param username
     * @param password
     * @param code
     * @param loginCallback
     */
    public static void login(String username, String password, String code, final LoginCallback<String> loginCallback) {
        String baseUrl = "http://192.168.0.100:7021/";
        //OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10L, TimeUnit.SECONDS)
                .readTimeout(10L, TimeUnit.SECONDS)
                .writeTimeout(10L, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
        //Api
        LoginService loginService = retrofit.create(LoginService.class);
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("code", code);
        Call<Boolean> call = loginService.login(paramMap);
        Callback<Boolean> callback = new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.body()) {
                    loginCallback.success("登录成功");
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                loginCallback.failed(t.getMessage(), t);
            }
        };
        call.enqueue(callback);
    }
}
