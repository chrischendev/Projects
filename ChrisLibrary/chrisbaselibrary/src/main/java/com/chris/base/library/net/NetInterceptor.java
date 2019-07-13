package com.chris.base.library.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:19
 * use for :
 */
class NetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
