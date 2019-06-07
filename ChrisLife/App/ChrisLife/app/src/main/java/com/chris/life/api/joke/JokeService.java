package com.chris.life.api.joke;

import com.chris.life.api.common.JuheResponse;
import com.chris.life.pages.read.joke.dummy.JokeContent;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * AiligouApp
 * com.alg.ailigouapp.common.api.home
 * Created by Chris Chen on 2017/7/5 17:01.
 * Explain:笑话网络请求接口
 */

public interface JokeService {

    //获取笑话数据
    @GET("/joke/content/list.php")
    Call<JuheResponse<JokeContent.JokeItem>> getJokeList(@QueryMap Map<String, Object> map);


}
