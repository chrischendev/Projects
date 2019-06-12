package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.SchoolTypeConverter;
import com.mars.edu.web.dao.repository.SchoolTypeRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SchoolTypeEntity;
import com.mars.edu.web.model.xio.SchoolTypeXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校类型 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class SchoolTypeService implements MarsXlsService<SchoolTypeEntity, SchoolTypeXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    SchoolTypeRepository schoolTypeRepository;
    @Autowired
    SchoolTypeConverter schoolTypeConverter;

    @Override
    public DataSourceHandlerBox<SchoolTypeEntity, SchoolTypeXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, schoolTypeRepository, new SchoolTypeEntity()),
                new XlsProcessHandler(this, schoolTypeConverter, SchoolTypeXio.class));
    }

}
