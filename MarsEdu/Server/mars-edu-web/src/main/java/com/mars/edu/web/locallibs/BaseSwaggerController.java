package com.mars.edu.web.locallibs;

import io.swagger.annotations.ApiOperation;
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
public interface BaseSwaggerController<T, ID extends Serializable, S extends BaseService> {
    S getService();

    //增加
    @PostMapping("/add")
    @ApiOperation(value = "增加")
    default boolean add(@RequestBody T entity) {
        return getService().add(entity);
    }

    //获取所有数据
    @GetMapping("/findById")
    @ApiOperation(value = "获取所有数据")
    default T findById(ID id) {
        return (T) getService().findById(id);
    }

    //获取所有数据
    @GetMapping("/findAll")
    @ApiOperation(value = "获取所有数据")
    default List<T> findAll() {
        return getService().findAll();
    }
}
