package com.mars.edu.app.api.news;

import com.mars.edu.app.library.net.NetClient;
import com.mars.edu.app.locallibs.net.NewsItem;
import com.mars.edu.app.locallibs.net.juhe.JuheResponse;
import com.mars.edu.app.locallibs.net.juhe.UrlConsts;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Chris Chen on 2019/7/9 17:09.
 * Explain:新闻 api
 */

public class NewsApi implements UrlConsts {
    private static NewsService service = NetClient.getRetrofit(JUHE_V_BASE_URL).create(NewsService.class);
    private static final String KEY = "93aa8c60492356f29d6fdf1a4a778556";

    //获取商品分类列表
    public static void getNewsList(String type, Callback<JuheResponse<NewsItem>> callback) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", KEY);
        map.put("type", type);//新闻分类
        Call call = service.getNewsList(map);
        call.enqueue(callback);
    }

}
