package com.mars.edu.web.service;

import com.mars.edu.web.converter.RoleConverter;
import com.mars.edu.web.dao.RoleRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SysRoleEntity;
import com.mars.edu.web.model.xio.RoleXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 14:06
 * Use for:
 */
@Service
public class RoleService implements MarsXlsService<SysRoleEntity, RoleXio> {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    EntityManager em;
    @Autowired
    RoleConverter roleConverter;

    @Override
    public DataSourceHandlerBox<SysRoleEntity, RoleXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(em, roleRepository, new SysRoleEntity()),
                new XlsProcessHandler(this, roleConverter, RoleXio.class));
    }
}
