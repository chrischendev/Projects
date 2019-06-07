package com.chris.life.api.weather;

import com.chris.life.api.NetClient;
import com.chris.life.api.common.JuheApisResponse;
import com.chris.life.api.common.UrlConsts;
import com.chris.life.pages.weather.WeatherInfo;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * AiligouApp
 * com.alg.ailigouapp.common.api.home
 * Created by Chris Chen on 2017/7/5 17:09.
 * Explain:天气 api
 */

public class WeatherApi implements UrlConsts {
    private static WeatherService service = NetClient.getRetrofit(JUHE_APIS_BASE_URL).create(WeatherService.class);
    private static final String KEY = "bd6091f90e2f77fd3b7b6be84efa0630";

    //获取天气信息
    public static void getWeatherInfo(String city, Callback<JuheApisResponse<WeatherInfo>> callback) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", KEY);
        map.put("city", city);//城市名或者城市id
        Call call = service.getWeatherInfo(map);
        call.enqueue(callback);
    }

}
