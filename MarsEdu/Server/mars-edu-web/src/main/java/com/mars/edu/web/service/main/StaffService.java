package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.StaffConverter;
import com.mars.edu.web.dao.repository.StaffRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.StaffEntity;
import com.mars.edu.web.model.xio.StaffXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 教职工 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class StaffService implements MarsXlsService<StaffEntity, StaffXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    StaffConverter staffConverter;

    @Override
    public DataSourceHandlerBox<StaffEntity, StaffXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, staffRepository, new StaffEntity()),
                new XlsProcessHandler(this, staffConverter, StaffXio.class));
    }

}
