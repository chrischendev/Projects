package com.mars.edu.web.service;

import com.mars.edu.web.dao.UserRoleRepository;
import com.mars.edu.web.locallibs.base.BaseService;
import com.mars.edu.web.locallibs.mars.MarsBaseService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.model.orm.SysUserRoleEntity;
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
public class UserRoleService implements MarsBaseService<SysUserRoleEntity> {
    @PersistenceContext
    EntityManager em;
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public DataSourceHandler<SysUserRoleEntity, Integer> getDataSourceHandler() {
        return new DataSourceHandler<>(em, userRoleRepository,new SysUserRoleEntity());
    }
}
