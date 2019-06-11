package com.mars.edu.web.locallibs.mars;

import com.mars.edu.web.locallibs.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 7:03
 * use for: mars-edu基本业务处理
 */
@Transactional
public interface MarsBaseService<T> extends BaseService<T, Integer> {
    @Override
    default boolean existId(T entity) {
        Class<?> entityClass = entity.getClass();
        try {
            Field idField = entityClass.getField("id");
            idField.setAccessible(true);
            Integer id = Integer.valueOf(String.valueOf(idField.get(entity)));
            idField.setAccessible(false);
            if (null != id) {
                return id.intValue() > 0;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
}
