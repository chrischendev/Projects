package com.mars.edu.web.service;

import com.mars.edu.web.converter.UserRoleConverter;
import com.mars.edu.web.dao.UserRoleRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SysUserRoleEntity;
import com.mars.edu.web.model.xio.UserRoleXio;
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
public class UserRoleService implements MarsXlsService<SysUserRoleEntity, UserRoleXio> {
    @Autowired
    EntityManager em;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    UserRoleConverter userRoleConverter;

    @Override
    public DataSourceHandlerBox<SysUserRoleEntity, UserRoleXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(em, userRoleRepository, new SysUserRoleEntity()),
                new XlsProcessHandler(this, userRoleConverter, UserRoleXio.class));
    }
}
