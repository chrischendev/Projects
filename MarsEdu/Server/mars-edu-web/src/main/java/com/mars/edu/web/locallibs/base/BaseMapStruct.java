package com.mars.edu.web.locallibs.base;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 11:11
 * Use for: 基本数据转换方法
 * E entity ORM对象 计算主体
 * T dto 数据传输对象
 */
public interface BaseMapStruct<E, T> {
    /**
     * dto转换为entity
     */
    E fromDto(T dto);

    /**
     * entity转换为dto
     */
    T toDto(E entity);

    /**
     * dto集合转换为entity集合
     */
    List<E> fromDtoList(List<T> dtoList);

    /**
     * entity集合转换为dto集合
     */
    List<T> toDtoList(List<E> entityList);
}
