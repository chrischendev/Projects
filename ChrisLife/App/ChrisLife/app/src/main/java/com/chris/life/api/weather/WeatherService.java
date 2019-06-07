package com.chris.life.api.weather;

import com.chris.life.api.common.JuheApisResponse;
import com.chris.life.api.common.JuheResponse;
import com.chris.life.pages.read.news.dummy.NewsContent;
import com.chris.life.pages.weather.WeatherInfo;

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

public interface WeatherService {

    //获取cengshi城市天气数据
    @GET("simpleWeather/query")
    Call<JuheApisResponse<WeatherInfo>> getWeatherInfo(@QueryMap Map<String, Object> map);


}
