package com.mars.edu.web.service;

import com.mars.edu.web.dao.RoleRepository;
import com.mars.edu.web.locallibs.mars.MarsBaseService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
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
public class RoleService implements MarsBaseService<SysRoleEntity> {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    EntityManager em;

    @Override
    public DataSourceHandler<SysRoleEntity, Integer> getDataSourceHandler() {
        return new DataSourceHandler<>(em, roleRepository, new SysRoleEntity());
    }
}
