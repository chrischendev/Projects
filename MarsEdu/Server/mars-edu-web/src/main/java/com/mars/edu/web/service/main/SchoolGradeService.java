package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.SchoolGradeConverter;
import com.mars.edu.web.dao.repository.SchoolGradeRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SchoolGradeEntity;
import com.mars.edu.web.model.xio.SchoolGradeXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 年级 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
public class SchoolGradeService implements MarsXlsService<SchoolGradeEntity, SchoolGradeXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    SchoolGradeRepository schoolGradeRepository;
    @Autowired
    SchoolGradeConverter schoolGradeConverter;

    @Override
    public DataSourceHandlerBox<SchoolGradeEntity, SchoolGradeXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, schoolGradeRepository, new SchoolGradeEntity()),
                new XlsProcessHandler(this, schoolGradeConverter, SchoolGradeXio.class));
    }

}
