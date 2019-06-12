package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.SchoolImagesConverter;
import com.mars.edu.web.dao.repository.SchoolImagesRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SchoolImagesEntity;
import com.mars.edu.web.model.xio.SchoolImagesXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校图片 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class SchoolImagesService implements MarsXlsService<SchoolImagesEntity, SchoolImagesXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    SchoolImagesRepository schoolImagesRepository;
    @Autowired
    SchoolImagesConverter schoolImagesConverter;

    @Override
    public DataSourceHandlerBox<SchoolImagesEntity, SchoolImagesXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, schoolImagesRepository, new SchoolImagesEntity()),
                new XlsProcessHandler(this, schoolImagesConverter, SchoolImagesXio.class));
    }

}
