package com.mars.edu.web.locallibs.base;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 11:11
 * Use for: 基本数据转换器
 * E entity ORM对象 计算主体
 * T dto 数据传输对象
 */
public interface BaseConverter<E, T> {
    /**
     * 创建一个空的ORM对象
     *
     * @return
     */
    E createEntity();

    /**
     * 创建一个空的DTO对象
     *
     * @return
     */
    T createDto();

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

    /**
     * 相似的dto转换为entity
     * 所谓相似，就是指dto和orm的部分字段极其类型相同，可以直接用BeanUtils复制
     */
    default E fromSameDto(T dto) {
        if (null == dto) {
            return null;
        }
        E entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * entity转换为相似的dto
     */
    default T toSameDto(E entity) {
        if (null == entity) {
            return null;
        }
        T dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    /**
     * 相似的dto集合转换为entity集合
     */
    default List<E> fromSameDtoList(List<T> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        List<E> entityList = new ArrayList<>();
        dtoList.stream().forEach(dto -> entityList.add(fromSameDto(dto)));
        return entityList;
    }

    /**
     * entity集合转换为相似的dto集合
     */
    default List<T> toSameDtoList(List<E> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        List<T> dtoList = new ArrayList<>();
        entityList.stream().forEach(entity -> dtoList.add(toSameDto(entity)));
        return dtoList;
    }
}
