package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.SchoolClassConverter;
import com.mars.edu.web.dao.repository.SchoolClassRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SchoolClassEntity;
import com.mars.edu.web.model.xio.SchoolClassXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 班级 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class SchoolClassService implements MarsXlsService<SchoolClassEntity, SchoolClassXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    SchoolClassRepository schoolClassRepository;
    @Autowired
    SchoolClassConverter schoolClassConverter;

    @Override
    public DataSourceHandlerBox<SchoolClassEntity, SchoolClassXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, schoolClassRepository, new SchoolClassEntity()),
                new XlsProcessHandler(this, schoolClassConverter, SchoolClassXio.class));
    }

}
