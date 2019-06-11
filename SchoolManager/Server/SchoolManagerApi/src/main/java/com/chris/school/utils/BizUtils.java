package com.chris.school.utils;

import java.lang.reflect.Field;

/**
 * YdxProvider
 * com.ydx.provider.utils
 * Created by Chris Chen
 * 2018/2/28
 * Explain:
 */
public class BizUtils {
    /**
     * 查找特定字段，设置默认值
     *
     * @param object
     * @param value
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void setDefaultValue(Object object, String fieldName, Object value) {
        Field field = null;
        try {
            field = object.getClass().getDeclaredField(fieldName);
            if (field != null) {
                field.setAccessible(true);
                field.set(object, value);//设置默认值
                field.setAccessible(false);
            }
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
    }
}
