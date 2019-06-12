package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.AdminEntity;
import com.mars.edu.web.model.xio.AdminXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 超级管理员 数据转换器
 */
@Service
public class AdminConverter implements BaseConverter<AdminEntity, AdminXio> {
    @Override
    public AdminEntity createEntity() {
        return new AdminEntity();
    }

    @Override
    public AdminXio createDto() {
        return new AdminXio();
    }

    @Override
    public AdminEntity fromDto(AdminXio dto) {
        if (null == dto) {
            return null;
        }
        AdminEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public AdminXio toDto(AdminEntity entity) {
        if (null == entity) {
            return null;
        }
        AdminXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<AdminEntity> fromDtoList(List<AdminXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<AdminXio> toDtoList(List<AdminEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
