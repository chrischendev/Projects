package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.ImagesTypeEntity;
import com.mars.edu.web.model.xio.ImagesTypeXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 图片类型 数据转换器
 */
@Service
public class ImagesTypeConverter implements BaseConverter<ImagesTypeEntity, ImagesTypeXio> {
    @Override
    public ImagesTypeEntity createEntity() {
        return new ImagesTypeEntity();
    }

    @Override
    public ImagesTypeXio createDto() {
        return new ImagesTypeXio();
    }

    @Override
    public ImagesTypeEntity fromDto(ImagesTypeXio dto) {
        if (null == dto) {
            return null;
        }
        ImagesTypeEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public ImagesTypeXio toDto(ImagesTypeEntity entity) {
        if (null == entity) {
            return null;
        }
        ImagesTypeXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<ImagesTypeEntity> fromDtoList(List<ImagesTypeXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<ImagesTypeXio> toDtoList(List<ImagesTypeEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
