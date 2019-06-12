package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.SchoolInfoConverter;
import com.mars.edu.web.dao.repository.SchoolInfoRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SchoolInfoEntity;
import com.mars.edu.web.model.xio.SchoolInfoXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校信息 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class SchoolInfoService implements MarsXlsService<SchoolInfoEntity, SchoolInfoXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    SchoolInfoRepository schoolInfoRepository;
    @Autowired
    SchoolInfoConverter schoolInfoConverter;

    @Override
    public DataSourceHandlerBox<SchoolInfoEntity, SchoolInfoXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, schoolInfoRepository, new SchoolInfoEntity()),
                new XlsProcessHandler(this, schoolInfoConverter, SchoolInfoXio.class));
    }

}
