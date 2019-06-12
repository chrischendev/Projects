package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.ClassSubjectConverter;
import com.mars.edu.web.dao.repository.ClassSubjectRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.ClassSubjectEntity;
import com.mars.edu.web.model.xio.ClassSubjectXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 班级开课计划 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class ClassSubjectService implements MarsXlsService<ClassSubjectEntity, ClassSubjectXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    ClassSubjectRepository classSubjectRepository;
    @Autowired
    ClassSubjectConverter classSubjectConverter;

    @Override
    public DataSourceHandlerBox<ClassSubjectEntity, ClassSubjectXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, classSubjectRepository, new ClassSubjectEntity()),
                new XlsProcessHandler(this, classSubjectConverter, ClassSubjectXio.class));
    }

}
