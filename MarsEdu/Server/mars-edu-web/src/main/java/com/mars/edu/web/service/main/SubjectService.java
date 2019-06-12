package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.SubjectConverter;
import com.mars.edu.web.dao.repository.SubjectRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SubjectEntity;
import com.mars.edu.web.model.xio.SubjectXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学科 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class SubjectService implements MarsXlsService<SubjectEntity, SubjectXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    SubjectConverter subjectConverter;

    @Override
    public DataSourceHandlerBox<SubjectEntity, SubjectXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, subjectRepository, new SubjectEntity()),
                new XlsProcessHandler(this, subjectConverter, SubjectXio.class));
    }

}
