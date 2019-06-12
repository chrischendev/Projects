package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SchoolTypeEntity;
import com.mars.edu.web.model.xio.SchoolTypeXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校类型 数据转换器
 */
@Service
public class SchoolTypeConverter implements BaseConverter<SchoolTypeEntity, SchoolTypeXio> {
    @Override
    public SchoolTypeEntity createEntity() {
        return new SchoolTypeEntity();
    }

    @Override
    public SchoolTypeXio createDto() {
        return new SchoolTypeXio();
    }

    @Override
    public SchoolTypeEntity fromDto(SchoolTypeXio dto) {
        if (null == dto) {
            return null;
        }
        SchoolTypeEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public SchoolTypeXio toDto(SchoolTypeEntity entity) {
        if (null == entity) {
            return null;
        }
        SchoolTypeXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SchoolTypeEntity> fromDtoList(List<SchoolTypeXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SchoolTypeXio> toDtoList(List<SchoolTypeEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
