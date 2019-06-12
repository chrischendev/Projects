package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.UserEntity;
import com.mars.edu.web.model.xio.UserXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户 数据转换器
 */
@Service
public class UserConverter implements BaseConverter<UserEntity, UserXio> {
    @Override
    public UserEntity createEntity() {
        return new UserEntity();
    }

    @Override
    public UserXio createDto() {
        return new UserXio();
    }

    @Override
    public UserEntity fromDto(UserXio dto) {
        if (null == dto) {
            return null;
        }
        UserEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public UserXio toDto(UserEntity entity) {
        if (null == entity) {
            return null;
        }
        UserXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<UserEntity> fromDtoList(List<UserXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<UserXio> toDtoList(List<UserEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
