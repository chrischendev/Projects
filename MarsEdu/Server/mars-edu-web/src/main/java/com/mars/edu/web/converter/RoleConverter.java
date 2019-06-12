package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.RoleEntity;
import com.mars.edu.web.model.xio.RoleXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 角色 数据转换器
 */
@Service
public class RoleConverter implements BaseConverter<RoleEntity, RoleXio> {
    @Override
    public RoleEntity createEntity() {
        return new RoleEntity();
    }

    @Override
    public RoleXio createDto() {
        return new RoleXio();
    }

    @Override
    public RoleEntity fromDto(RoleXio dto) {
        if (null == dto) {
            return null;
        }
        RoleEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public RoleXio toDto(RoleEntity entity) {
        if (null == entity) {
            return null;
        }
        RoleXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<RoleEntity> fromDtoList(List<RoleXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<RoleXio> toDtoList(List<RoleEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
