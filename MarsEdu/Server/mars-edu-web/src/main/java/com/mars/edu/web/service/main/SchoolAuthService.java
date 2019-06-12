package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.SchoolAuthConverter;
import com.mars.edu.web.dao.repository.SchoolAuthRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SchoolAuthEntity;
import com.mars.edu.web.model.xio.SchoolAuthXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校授权码 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class SchoolAuthService implements MarsXlsService<SchoolAuthEntity, SchoolAuthXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    SchoolAuthRepository schoolAuthRepository;
    @Autowired
    SchoolAuthConverter schoolAuthConverter;

    @Override
    public DataSourceHandlerBox<SchoolAuthEntity, SchoolAuthXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, schoolAuthRepository, new SchoolAuthEntity()),
                new XlsProcessHandler(this, schoolAuthConverter, SchoolAuthXio.class));
    }

}
