package com.mars.edu.app.locallibs.net.weather;

import java.util.List;

/**
 * 天气
 */
public class WeatherInfo {
    /*
    		"city":"上海",
		    "realtime":{
			"temperature":"32",
			"humidity":"18",
			"info":"阴",
			"wid":"02",
			"direct":"西北风",
			"power":"1级",
			"aqi":"83"
		},
		"future":[
			{
     */

    public String city;
    public RealTimeWeather realtime;
    public List<FutureWeather> future;
}
