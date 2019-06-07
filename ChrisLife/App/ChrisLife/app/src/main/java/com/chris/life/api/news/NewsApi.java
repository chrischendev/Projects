package com.chris.life.api.news;

import com.chris.life.api.NetClient;
import com.chris.life.api.common.JuheResponse;
import com.chris.life.api.common.UrlConsts;
import com.chris.life.pages.read.news.dummy.NewsContent;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * AiligouApp
 * com.alg.ailigouapp.common.api.home
 * Created by Chris Chen on 2017/7/5 17:09.
 * Explain:新闻 api
 */

public class NewsApi implements UrlConsts {
    private static NewsService service = NetClient.getRetrofit(JUHE_V_BASE_URL).create(NewsService.class);
    private static final String KEY = "93aa8c60492356f29d6fdf1a4a778556";

    //获取商品分类列表
    public static void getNewsList(String type, Callback<JuheResponse<NewsContent.NewsItem>> callback) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", KEY);
        map.put("type", type);//新闻分类
        Call call = service.getNewsList(map);
        call.enqueue(callback);
    }

}
