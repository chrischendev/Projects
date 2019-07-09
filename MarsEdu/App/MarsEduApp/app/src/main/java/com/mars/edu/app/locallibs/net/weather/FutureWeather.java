package com.mars.edu.app.locallibs.net.weather;

/**
 * 未来天气信息
 */
public class FutureWeather {
    /*
                "date":"2019-05-24",
				"temperature":"21\/34℃",
				"weather":"多云转阴",
				"wid":{
					"day":"01",
					"night":"02"
				},
				"direct":"东南风"
     */

    public String date;
    public String temperature;
    public String weather;
    public WidInfo wid;
    public String direct;
}
