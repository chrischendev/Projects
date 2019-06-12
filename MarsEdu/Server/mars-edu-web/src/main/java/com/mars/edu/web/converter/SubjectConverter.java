package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SubjectEntity;
import com.mars.edu.web.model.xio.SubjectXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学科 数据转换器
 */
@Service
public class SubjectConverter implements BaseConverter<SubjectEntity, SubjectXio> {
    @Override
    public SubjectEntity createEntity() {
        return new SubjectEntity();
    }

    @Override
    public SubjectXio createDto() {
        return new SubjectXio();
    }

    @Override
    public SubjectEntity fromDto(SubjectXio dto) {
        if (null == dto) {
            return null;
        }
        SubjectEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public SubjectXio toDto(SubjectEntity entity) {
        if (null == entity) {
            return null;
        }
        SubjectXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SubjectEntity> fromDtoList(List<SubjectXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SubjectXio> toDtoList(List<SubjectEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
