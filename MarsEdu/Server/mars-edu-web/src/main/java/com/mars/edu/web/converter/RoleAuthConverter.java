package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SysRoleAuthEntity;
import com.mars.edu.web.model.xio.RoleAuthXio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 17:27
 * Use for: 角色 数据转换器
 */
@Service
public class RoleAuthConverter implements BaseConverter<SysRoleAuthEntity, RoleAuthXio> {
    @Override
    public SysRoleAuthEntity createEntity() {
        return new SysRoleAuthEntity();
    }

    @Override
    public RoleAuthXio createDto() {
        return new RoleAuthXio();
    }

    @Override
    public SysRoleAuthEntity fromDto(RoleAuthXio dto) {
        return null;
    }

    @Override
    public RoleAuthXio toDto(SysRoleAuthEntity entity) {
        return null;
    }

    @Override
    public List<SysRoleAuthEntity> fromDtoList(List<RoleAuthXio> dtoList) {
        return null;
    }

    @Override
    public List<RoleAuthXio> toDtoList(List<SysRoleAuthEntity> entityList) {
        return null;
    }
}
