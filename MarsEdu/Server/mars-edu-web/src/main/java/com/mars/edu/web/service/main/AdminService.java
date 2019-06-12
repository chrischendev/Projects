package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.AdminConverter;
import com.mars.edu.web.dao.repository.AdminRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.AdminEntity;
import com.mars.edu.web.model.xio.AdminXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 超级管理员 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class AdminService implements MarsXlsService<AdminEntity, AdminXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminConverter adminConverter;

    @Override
    public DataSourceHandlerBox<AdminEntity, AdminXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, adminRepository, new AdminEntity()),
                new XlsProcessHandler(this, adminConverter, AdminXio.class));
    }

}
