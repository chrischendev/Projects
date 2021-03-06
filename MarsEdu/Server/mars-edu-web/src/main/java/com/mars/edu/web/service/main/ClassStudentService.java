package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.ClassStudentConverter;
import com.mars.edu.web.dao.repository.ClassStudentRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.ClassStudentEntity;
import com.mars.edu.web.model.xio.ClassStudentXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 班级学生 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class ClassStudentService implements MarsXlsService<ClassStudentEntity, ClassStudentXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    ClassStudentRepository classStudentRepository;
    @Autowired
    ClassStudentConverter classStudentConverter;

    @Override
    public DataSourceHandlerBox<ClassStudentEntity, ClassStudentXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, classStudentRepository, new ClassStudentEntity()),
                new XlsProcessHandler(this, classStudentConverter, ClassStudentXio.class));
    }

}
