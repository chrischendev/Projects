package com.mars.edu.web.service;

import com.mars.edu.web.dao.AuthRepository;
import com.mars.edu.web.locallibs.mars.MarsBaseService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.model.orm.SysAuthEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 14:44
 * Use for:
 */
@Service
public class AuthService implements MarsBaseService<SysAuthEntity> {
    @Autowired
    AuthRepository authRepository;
    @Autowired
    EntityManager em;

    @Override
    public DataSourceHandler<SysAuthEntity, Integer> getDataSourceHandler() {
        return new DataSourceHandler<>(em, authRepository, new SysAuthEntity());
    }
}
