package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.UserInfoConverter;
import com.mars.edu.web.dao.repository.UserInfoRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.UserInfoEntity;
import com.mars.edu.web.model.xio.UserInfoXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户信息 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class UserInfoService implements MarsXlsService<UserInfoEntity, UserInfoXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserInfoConverter userInfoConverter;

    @Override
    public DataSourceHandlerBox<UserInfoEntity, UserInfoXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, userInfoRepository, new UserInfoEntity()),
                new XlsProcessHandler(this, userInfoConverter, UserInfoXio.class));
    }

}
