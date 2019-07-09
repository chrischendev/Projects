package com.mars.edu.app.api.news;

import com.mars.edu.app.locallibs.net.NewsItem;
import com.mars.edu.app.locallibs.net.juhe.JuheResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Chris Chen on 2019/7/9 17:01.
 * Explain:新闻网络请求接口
 */

public interface NewsService {

    //获取头条新闻数据
    @GET("toutiao/index")
    Call<JuheResponse<NewsItem>> getNewsList(@QueryMap Map<String, Object> map);


}
