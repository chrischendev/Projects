package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.SysRoleEntity;
import com.mars.edu.web.model.xio.RoleXio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 17:27
 * Use for: 角色 数据转换器
 */
@Service
public class RoleConverter implements BaseConverter<SysRoleEntity, RoleXio> {
    @Override
    public SysRoleEntity createEntity() {
        return new SysRoleEntity();
    }

    @Override
    public RoleXio createDto() {
        return new RoleXio();
    }

    @Override
    public SysRoleEntity fromDto(RoleXio dto) {
        return null;
    }

    @Override
    public RoleXio toDto(SysRoleEntity entity) {
        RoleXio roleXio = new RoleXio();
        roleXio.setName(entity.getName());
        roleXio.setCode(entity.getCode());
        return roleXio;
    }

    @Override
    public List<SysRoleEntity> fromDtoList(List<RoleXio> dtoList) {
        return null;
    }

    @Override
    public List<RoleXio> toDtoList(List<SysRoleEntity> entityList) {
        return null;
    }
}
