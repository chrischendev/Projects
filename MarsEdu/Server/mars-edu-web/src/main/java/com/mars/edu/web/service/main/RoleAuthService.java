package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.RoleAuthConverter;
import com.mars.edu.web.dao.repository.RoleAuthRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.RoleAuthEntity;
import com.mars.edu.web.model.xio.RoleAuthXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 角色权限关联 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class RoleAuthService implements MarsXlsService<RoleAuthEntity, RoleAuthXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    RoleAuthRepository roleAuthRepository;
    @Autowired
    RoleAuthConverter roleAuthConverter;

    @Override
    public DataSourceHandlerBox<RoleAuthEntity, RoleAuthXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, roleAuthRepository, new RoleAuthEntity()),
                new XlsProcessHandler(this, roleAuthConverter, RoleAuthXio.class));
    }

}
