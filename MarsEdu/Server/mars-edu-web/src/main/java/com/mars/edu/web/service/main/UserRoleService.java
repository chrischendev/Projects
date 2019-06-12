package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.UserRoleConverter;
import com.mars.edu.web.dao.repository.UserRoleRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.UserRoleEntity;
import com.mars.edu.web.model.xio.UserRoleXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户角色关联 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class UserRoleService implements MarsXlsService<UserRoleEntity, UserRoleXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    UserRoleConverter userRoleConverter;

    @Override
    public DataSourceHandlerBox<UserRoleEntity, UserRoleXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, userRoleRepository, new UserRoleEntity()),
                new XlsProcessHandler(this, userRoleConverter, UserRoleXio.class));
    }

}
