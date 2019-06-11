package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SysUserEntity;
import com.mars.edu.web.model.orm.SysUserRoleEntity;
import com.mars.edu.web.model.xio.UserRoleXio;
import com.mars.edu.web.model.xio.UserXio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 16:31
 * Use for: 用户 数据转换器
 */
@Service
public class UserRoleConverter implements BaseConverter<SysUserRoleEntity, UserRoleXio> {

    @Override
    public SysUserRoleEntity createEntity() {
        return new SysUserRoleEntity();
    }

    @Override
    public UserRoleXio createDto() {
        return new UserRoleXio();
    }

    @Override
    public SysUserRoleEntity fromDto(UserRoleXio dto) {
        return null;
    }

    @Override
    public UserRoleXio toDto(SysUserRoleEntity entity) {
        return null;
    }

    @Override
    public List<SysUserRoleEntity> fromDtoList(List<UserRoleXio> dtoList) {
        return null;
    }

    @Override
    public List<UserRoleXio> toDtoList(List<SysUserRoleEntity> entityList) {
        return null;
    }
}
