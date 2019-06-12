package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.StudentConverter;
import com.mars.edu.web.dao.repository.StudentRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.StudentEntity;
import com.mars.edu.web.model.xio.StudentXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学生 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class StudentService implements MarsXlsService<StudentEntity, StudentXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentConverter studentConverter;

    @Override
    public DataSourceHandlerBox<StudentEntity, StudentXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, studentRepository, new StudentEntity()),
                new XlsProcessHandler(this, studentConverter, StudentXio.class));
    }

}
