package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.UserRoleEntity;
import com.mars.edu.web.model.xio.UserRoleXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户角色关联 数据转换器
 */
@Service
public class UserRoleConverter implements BaseConverter<UserRoleEntity, UserRoleXio> {
    @Override
    public UserRoleEntity createEntity() {
        return new UserRoleEntity();
    }

    @Override
    public UserRoleXio createDto() {
        return new UserRoleXio();
    }

    @Override
    public UserRoleEntity fromDto(UserRoleXio dto) {
        if (null == dto) {
            return null;
        }
        UserRoleEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public UserRoleXio toDto(UserRoleEntity entity) {
        if (null == entity) {
            return null;
        }
        UserRoleXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<UserRoleEntity> fromDtoList(List<UserRoleXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<UserRoleXio> toDtoList(List<UserRoleEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
