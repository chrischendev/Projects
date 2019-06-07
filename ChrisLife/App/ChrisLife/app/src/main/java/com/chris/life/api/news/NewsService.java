package com.chris.life.api.news;

import com.chris.life.api.common.JuheResponse;
import com.chris.life.pages.read.news.dummy.NewsContent;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * AiligouApp
 * com.alg.ailigouapp.common.api.home
 * Created by Chris Chen on 2017/7/5 17:01.
 * Explain:新闻网络请求接口
 */

public interface NewsService {

    //获取头条新闻数据
    @GET("toutiao/index")
    Call<JuheResponse<NewsContent.NewsItem>> getNewsList(@QueryMap Map<String, Object> map);


}
