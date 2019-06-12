package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SchoolEntity;
import com.mars.edu.web.model.xio.SchoolAuthXio;
import com.mars.edu.web.model.xio.SchoolXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校 数据转换器
 */
@Service
public class SchoolConverter implements BaseConverter<SchoolEntity, SchoolXio> {
    @Override
    public SchoolEntity createEntity() {
        return new SchoolEntity();
    }

    @Override
    public SchoolXio createDto() {
        return new SchoolXio();
    }

    @Override
    public SchoolEntity fromDto(SchoolXio dto) {
        if (null == dto) {
            return null;
        }
        SchoolEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public SchoolXio toDto(SchoolEntity entity) {
        if (null == entity) {
            return null;
        }
        SchoolXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SchoolEntity> fromDtoList(List<SchoolXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SchoolXio> toDtoList(List<SchoolEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
