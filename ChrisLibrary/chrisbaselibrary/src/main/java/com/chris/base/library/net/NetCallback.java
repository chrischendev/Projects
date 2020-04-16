package com.chris.base.library.net;

import com.chris.base.library.utils.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:27
 * use for :
 */
public abstract class NetCallback<T> implements Callback<T> {
    //需要查看未经过json格式转换工厂的返回数据，可以打开拦截器查看
    @Override
    public void onResponse(Call call, Response response) {
        //如果请求成功
        if (response.code() == 200) {
            //解析json
            T body = (T) response.body();
            //如果数据不为空
            if (body != null) {
                onComplete(new NetResponse<>(call, true, NetStatus.SUCCESS, body));
            } else {
                //如果数据为空
                onComplete(new NetResponse<>(call, true, NetStatus.DATA_EMPTY, null));
            }
        }else{
            onComplete(new NetResponse<>(call, false, NetStatus.DATA_ERROR, null));
        }
    }

    /**
     * 请求完成后调用的方法，进行具体的处理
     *
     * @param netResponse
     */
    protected abstract void onComplete(NetResponse<T> netResponse);


    @Override
    public void onFailure(Call call, Throwable t) {
        t.printStackTrace();
        //判断网网络情况
        if (NetworkUtils.isNetworkConnected()) {
            onComplete(new NetResponse<>(call, false, NetStatus.NET_ERROR, null));
        } else {
            onComplete(new NetResponse<>(call, false, NetStatus.DATA_ERROR, null));
        }
    }
}
