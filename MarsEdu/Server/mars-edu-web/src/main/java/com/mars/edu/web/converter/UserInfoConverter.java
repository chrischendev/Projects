package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.UserInfoEntity;
import com.mars.edu.web.model.xio.UserInfoXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户信息 数据转换器
 */
@Service
public class UserInfoConverter implements BaseConverter<UserInfoEntity, UserInfoXio> {
    @Override
    public UserInfoEntity createEntity() {
        return new UserInfoEntity();
    }

    @Override
    public UserInfoXio createDto() {
        return new UserInfoXio();
    }

    @Override
    public UserInfoEntity fromDto(UserInfoXio dto) {
        if (null == dto) {
            return null;
        }
        UserInfoEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public UserInfoXio toDto(UserInfoEntity entity) {
        if (null == entity) {
            return null;
        }
        UserInfoXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<UserInfoEntity> fromDtoList(List<UserInfoXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<UserInfoXio> toDtoList(List<UserInfoEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
