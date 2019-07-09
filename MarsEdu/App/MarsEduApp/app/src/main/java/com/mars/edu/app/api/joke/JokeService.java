package com.mars.edu.app.api.joke;

import com.mars.edu.app.locallibs.net.JokeItem;
import com.mars.edu.app.locallibs.net.juhe.JuheResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Chris Chen on 2019/7/9 17:01.
 * Explain:笑话网络请求接口
 */

public interface JokeService {

    //获取笑话数据
    @GET("/joke/content/list.php")
    Call<JuheResponse<JokeItem>> getJokeList(@QueryMap Map<String, Object> map);


}
