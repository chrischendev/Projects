package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SchoolClassEntity;
import com.mars.edu.web.model.xio.SchoolClassXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 班级 数据转换器
 */
@Service
public class SchoolClassConverter implements BaseConverter<SchoolClassEntity, SchoolClassXio> {
    @Override
    public SchoolClassEntity createEntity() {
        return new SchoolClassEntity();
    }

    @Override
    public SchoolClassXio createDto() {
        return new SchoolClassXio();
    }

    @Override
    public SchoolClassEntity fromDto(SchoolClassXio dto) {
        if (null == dto) {
            return null;
        }
        SchoolClassEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public SchoolClassXio toDto(SchoolClassEntity entity) {
        if (null == entity) {
            return null;
        }
        SchoolClassXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SchoolClassEntity> fromDtoList(List<SchoolClassXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SchoolClassXio> toDtoList(List<SchoolClassEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
