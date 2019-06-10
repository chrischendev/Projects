package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SysAuthEntity;
import com.mars.edu.web.model.orm.SysRoleEntity;
import com.mars.edu.web.model.xio.AuthXio;
import com.mars.edu.web.model.xio.RoleXio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 17:27
 * Use for: 权限 数据转换器
 */
@Service
public class AuthConverter implements BaseConverter<SysAuthEntity, AuthXio> {

    @Override
    public SysAuthEntity createEntity() {
        return new SysAuthEntity();
    }

    @Override
    public AuthXio createDto() {
        return new AuthXio();
    }

    @Override
    public SysAuthEntity fromDto(AuthXio dto) {
        return null;
    }

    @Override
    public AuthXio toDto(SysAuthEntity entity) {
        return null;
    }

    @Override
    public List<SysAuthEntity> fromDtoList(List<AuthXio> dtoList) {
        return null;
    }

    @Override
    public List<AuthXio> toDtoList(List<SysAuthEntity> entityList) {
        return null;
    }
}
