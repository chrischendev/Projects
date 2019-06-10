package com.mars.edu.web.locallibs.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/6/9 23:10
 * use for:
 */
public interface BaseController<T, ID extends Serializable, S extends BaseService> {
    S getService();

    //增加
    @PostMapping("/add")
    default boolean add(@RequestBody T entity) {
        return getService().add(entity);
    }

    //获取所有数据
    @GetMapping("/findById")
    default T findById(ID id) {
        return (T) getService().findById(id);
    }

    //获取所有数据
    @GetMapping("/findAll")
    default List<T> findAll() {
        return getService().findAll();
    }
}
