package com.mars.edu.web.service;

import com.mars.edu.web.dao.RoleAuthRepository;
import com.mars.edu.web.locallibs.mars.MarsBaseService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.model.orm.SysRoleAuthEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 14:06
 * Use for:
 */
@Service
public class RoleAuthService implements MarsBaseService<SysRoleAuthEntity> {
    @PersistenceContext
    EntityManager em;
    @Autowired
    RoleAuthRepository roleAuthRepository;

    @Override
    public DataSourceHandler<SysRoleAuthEntity, Integer> getDataSourceHandler() {
        return new DataSourceHandler<>(em, roleAuthRepository, new SysRoleAuthEntity());
    }
}
