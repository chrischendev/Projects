package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.RoleAuthEntity;
import com.mars.edu.web.model.xio.RoleAuthXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 角色权限关联 数据转换器
 */
@Service
public class RoleAuthConverter implements BaseConverter<RoleAuthEntity, RoleAuthXio> {
    @Override
    public RoleAuthEntity createEntity() {
        return new RoleAuthEntity();
    }

    @Override
    public RoleAuthXio createDto() {
        return new RoleAuthXio();
    }

    @Override
    public RoleAuthEntity fromDto(RoleAuthXio dto) {
        if (null == dto) {
            return null;
        }
        RoleAuthEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public RoleAuthXio toDto(RoleAuthEntity entity) {
        if (null == entity) {
            return null;
        }
        RoleAuthXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<RoleAuthEntity> fromDtoList(List<RoleAuthXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<RoleAuthXio> toDtoList(List<RoleAuthEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
