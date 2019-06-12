package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.AuthEntity;
import com.mars.edu.web.model.xio.AuthXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 权限 数据转换器
 */
@Service
public class AuthConverter implements BaseConverter<AuthEntity, AuthXio> {
    @Override
    public AuthEntity createEntity() {
        return new AuthEntity();
    }

    @Override
    public AuthXio createDto() {
        return new AuthXio();
    }

    @Override
    public AuthEntity fromDto(AuthXio dto) {
        if (null == dto) {
            return null;
        }
        AuthEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public AuthXio toDto(AuthEntity entity) {
        if (null == entity) {
            return null;
        }
        AuthXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<AuthEntity> fromDtoList(List<AuthXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<AuthXio> toDtoList(List<AuthEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
