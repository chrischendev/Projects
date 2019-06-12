package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.AuthConverter;
import com.mars.edu.web.dao.repository.AuthRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.AuthEntity;
import com.mars.edu.web.model.xio.AuthXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 权限 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class AuthService implements MarsXlsService<AuthEntity, AuthXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    AuthRepository authRepository;
    @Autowired
    AuthConverter authConverter;

    @Override
    public DataSourceHandlerBox<AuthEntity, AuthXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, authRepository, new AuthEntity()),
                new XlsProcessHandler(this, authConverter, AuthXio.class));
    }

}
