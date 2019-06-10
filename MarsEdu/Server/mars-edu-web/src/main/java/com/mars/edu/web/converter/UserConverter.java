package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SysUserEntity;
import com.mars.edu.web.model.xio.UserXio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 16:31
 * Use for:
 */
@Service
public class UserConverter implements BaseConverter<SysUserEntity, UserXio> {
    @Override
    public SysUserEntity createEntity() {
        return new SysUserEntity();
    }

    @Override
    public UserXio createDto() {
        return new UserXio();
    }

    @Override
    public SysUserEntity fromDto(UserXio dto) {
        return null;
    }

    @Override
    public UserXio toDto(SysUserEntity entity) {
        return null;
    }

    @Override
    public List<SysUserEntity> fromDtoList(List<UserXio> dtoList) {
        return null;
    }

    @Override
    public List<UserXio> toDtoList(List<SysUserEntity> entityList) {
        return null;
    }
}
