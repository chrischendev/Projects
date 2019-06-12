package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SchoolAuthEntity;
import com.mars.edu.web.model.xio.SchoolAuthXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校授权码 数据转换器
 */
@Service
public class SchoolAuthConverter implements BaseConverter<SchoolAuthEntity, SchoolAuthXio> {
    @Override
    public SchoolAuthEntity createEntity() {
        return new SchoolAuthEntity();
    }

    @Override
    public SchoolAuthXio createDto() {
        return new SchoolAuthXio();
    }

    @Override
    public SchoolAuthEntity fromDto(SchoolAuthXio dto) {
        if (null == dto) {
            return null;
        }
        SchoolAuthEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public SchoolAuthXio toDto(SchoolAuthEntity entity) {
        if (null == entity) {
            return null;
        }
        SchoolAuthXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SchoolAuthEntity> fromDtoList(List<SchoolAuthXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SchoolAuthXio> toDtoList(List<SchoolAuthEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
