package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.ImagesTypeConverter;
import com.mars.edu.web.dao.repository.ImagesTypeRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.ImagesTypeEntity;
import com.mars.edu.web.model.xio.ImagesTypeXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 图片类型 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class ImagesTypeService implements MarsXlsService<ImagesTypeEntity, ImagesTypeXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    ImagesTypeRepository imagesTypeRepository;
    @Autowired
    ImagesTypeConverter imagesTypeConverter;

    @Override
    public DataSourceHandlerBox<ImagesTypeEntity, ImagesTypeXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, imagesTypeRepository, new ImagesTypeEntity()),
                new XlsProcessHandler(this, imagesTypeConverter, ImagesTypeXio.class));
    }

}
