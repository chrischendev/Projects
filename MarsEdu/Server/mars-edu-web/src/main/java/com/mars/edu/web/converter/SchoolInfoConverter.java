package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SchoolInfoEntity;
import com.mars.edu.web.model.xio.SchoolInfoXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校信息 数据转换器
 */
@Service
public class SchoolInfoConverter implements BaseConverter<SchoolInfoEntity, SchoolInfoXio> {
    @Override
    public SchoolInfoEntity createEntity() {
        return new SchoolInfoEntity();
    }

    @Override
    public SchoolInfoXio createDto() {
        return new SchoolInfoXio();
    }

    @Override
    public SchoolInfoEntity fromDto(SchoolInfoXio dto) {
        if (null == dto) {
            return null;
        }
        SchoolInfoEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public SchoolInfoXio toDto(SchoolInfoEntity entity) {
        if (null == entity) {
            return null;
        }
        SchoolInfoXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SchoolInfoEntity> fromDtoList(List<SchoolInfoXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SchoolInfoXio> toDtoList(List<SchoolInfoEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
