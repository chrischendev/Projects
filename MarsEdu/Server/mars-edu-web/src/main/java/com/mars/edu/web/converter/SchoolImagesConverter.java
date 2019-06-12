package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SchoolImagesEntity;
import com.mars.edu.web.model.xio.SchoolImagesXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校图片 数据转换器
 */
@Service
public class SchoolImagesConverter implements BaseConverter<SchoolImagesEntity, SchoolImagesXio> {
    @Override
    public SchoolImagesEntity createEntity() {
        return new SchoolImagesEntity();
    }

    @Override
    public SchoolImagesXio createDto() {
        return new SchoolImagesXio();
    }

    @Override
    public SchoolImagesEntity fromDto(SchoolImagesXio dto) {
        if (null == dto) {
            return null;
        }
        SchoolImagesEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public SchoolImagesXio toDto(SchoolImagesEntity entity) {
        if (null == entity) {
            return null;
        }
        SchoolImagesXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SchoolImagesEntity> fromDtoList(List<SchoolImagesXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SchoolImagesXio> toDtoList(List<SchoolImagesEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
