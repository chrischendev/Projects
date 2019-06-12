package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SchoolGradeEntity;
import com.mars.edu.web.model.xio.SchoolGradeXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 年级 数据转换器
 */
@Service
public class SchoolGradeConverter implements BaseConverter<SchoolGradeEntity, SchoolGradeXio> {
    @Override
    public SchoolGradeEntity createEntity() {
        return new SchoolGradeEntity();
    }

    @Override
    public SchoolGradeXio createDto() {
        return new SchoolGradeXio();
    }

    @Override
    public SchoolGradeEntity fromDto(SchoolGradeXio dto) {
        if (null == dto) {
            return null;
        }
        SchoolGradeEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public SchoolGradeXio toDto(SchoolGradeEntity entity) {
        if (null == entity) {
            return null;
        }
        SchoolGradeXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SchoolGradeEntity> fromDtoList(List<SchoolGradeXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SchoolGradeXio> toDtoList(List<SchoolGradeEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
