package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.SchoolConverter;
import com.mars.edu.web.dao.repository.SchoolRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SchoolEntity;
import com.mars.edu.web.model.xio.SchoolXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class SchoolService implements MarsXlsService<SchoolEntity, SchoolXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    SchoolConverter schoolConverter;

    @Override
    public DataSourceHandlerBox<SchoolEntity, SchoolXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, schoolRepository, new SchoolEntity()),
                new XlsProcessHandler(this, schoolConverter, SchoolXio.class));
    }

}
