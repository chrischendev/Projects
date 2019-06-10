package com.mars.edu.web.service;

import com.mars.edu.web.dao.RoleRepository;
import com.mars.edu.web.locallibs.base.BaseService;
import com.mars.edu.web.model.orm.SysRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 14:06
 * Use for:
 */
@Service
public class RoleService implements BaseService<SysRoleEntity, Integer, RoleRepository> {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    EntityManager em;

    @Override
    public RoleRepository getRepository() {
        return roleRepository;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public SysRoleEntity createEntity() {
        return new SysRoleEntity();
    }

    @Override
    public SysRoleEntity addId(SysRoleEntity entity, Integer integer) {
        entity.setId(integer);
        return entity;
    }

    @Override
    public boolean existId(SysRoleEntity entity) {
        return entity.getId() > 0;
    }
}
