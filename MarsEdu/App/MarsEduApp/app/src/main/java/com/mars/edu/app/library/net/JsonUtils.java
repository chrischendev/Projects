package com.mars.edu.app.library.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:24
 * use for :
 */
public class JsonUtils {
    private final static Gson gson = new Gson();

    /**
     * object转换为json字符串
     *
     * @param object
     * @return
     */
    public static String objToJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * json字符串解析为object
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObj(String jsonStr, Class<T> clazz) {
        try {
            return gson.fromJson(jsonStr, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json字符串解析为List
     *
     * @param jsonStr
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonStr) {
        try {
            Type type = new TypeToken<List<T>>() {
            }.getType();
            return gson.fromJson(jsonStr, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
