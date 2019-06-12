package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.RoleConverter;
import com.mars.edu.web.dao.repository.RoleRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.RoleEntity;
import com.mars.edu.web.model.xio.RoleXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 角色 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class RoleService implements MarsXlsService<RoleEntity, RoleXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleConverter roleConverter;

    @Override
    public DataSourceHandlerBox<RoleEntity, RoleXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, roleRepository, new RoleEntity()),
                new XlsProcessHandler(this, roleConverter, RoleXio.class));
    }

}
