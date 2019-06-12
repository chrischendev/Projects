package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.StaffEntity;
import com.mars.edu.web.model.xio.StaffXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 教职工 数据转换器
 */
@Service
public class StaffConverter implements BaseConverter<StaffEntity, StaffXio> {
    @Override
    public StaffEntity createEntity() {
        return new StaffEntity();
    }

    @Override
    public StaffXio createDto() {
        return new StaffXio();
    }

    @Override
    public StaffEntity fromDto(StaffXio dto) {
        if (null == dto) {
            return null;
        }
        StaffEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public StaffXio toDto(StaffEntity entity) {
        if (null == entity) {
            return null;
        }
        StaffXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<StaffEntity> fromDtoList(List<StaffXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<StaffXio> toDtoList(List<StaffEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
