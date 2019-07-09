package com.mars.edu.app.api.weather;

import com.mars.edu.app.locallibs.net.juhe.JuheApisResponse;
import com.mars.edu.app.locallibs.net.weather.WeatherInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Chris Chen on 2019/7/9 17:01.
 * Explain:新闻网络请求接口
 */

public interface WeatherService {

    //获取城市天气数据
    @GET("simpleWeather/query")
    Call<JuheApisResponse<WeatherInfo>> getWeatherInfo(@QueryMap Map<String, Object> map);


}
