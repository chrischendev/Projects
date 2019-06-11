package com.mars.edu.web.service;

import com.mars.edu.web.converter.RoleAuthConverter;
import com.mars.edu.web.dao.RoleAuthRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SysRoleAuthEntity;
import com.mars.edu.web.model.xio.RoleAuthXio;
import com.mars.edu.web.model.xio.RoleXio;
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
public class RoleAuthService implements MarsXlsService<SysRoleAuthEntity, RoleAuthXio> {
    @Autowired
    EntityManager em;
    @Autowired
    RoleAuthRepository roleAuthRepository;
    @Autowired
    RoleAuthConverter roleAuthConverter;

    @Override
    public DataSourceHandlerBox<SysRoleAuthEntity, RoleAuthXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(em, roleAuthRepository, new SysRoleAuthEntity()),
                new XlsProcessHandler<>(this, roleAuthConverter, RoleAuthXio.class));
    }
}
