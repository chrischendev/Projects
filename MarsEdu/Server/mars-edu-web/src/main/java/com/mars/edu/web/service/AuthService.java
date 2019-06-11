package com.mars.edu.web.service;

import com.mars.edu.web.converter.AuthConverter;
import com.mars.edu.web.dao.AuthRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.SysAuthEntity;
import com.mars.edu.web.model.xio.AuthXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 14:44
 * Use for:
 */
@Service
public class AuthService implements MarsXlsService<SysAuthEntity, AuthXio> {
    @Autowired
    AuthRepository authRepository;
    @Autowired
    EntityManager em;
    @Autowired
    AuthConverter authConverter;

    @Override
    public DataSourceHandlerBox<SysAuthEntity, AuthXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(em, authRepository, new SysAuthEntity()),
                new XlsProcessHandler<>(this, authConverter, AuthXio.class));
    }

}
