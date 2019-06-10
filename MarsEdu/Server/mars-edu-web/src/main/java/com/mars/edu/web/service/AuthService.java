package com.mars.edu.web.service;

import com.mars.edu.web.dao.AuthRepository;
import com.mars.edu.web.locallibs.base.BaseService;
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
public class AuthService implements BaseService<SysAuthEntity, Integer, AuthRepository> {
    @Autowired
    AuthRepository authRepository;
    @Autowired
    EntityManager em;

    @Override
    public AuthRepository getRepository() {
        return authRepository;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public SysAuthEntity createEntity() {
        return new SysAuthEntity();
    }

    @Override
    public SysAuthEntity addId(SysAuthEntity entity, Integer integer) {
        entity.setId(integer);
        return entity;
    }

    @Override
    public boolean existId(SysAuthEntity entity) {
        return entity.getId() > 0;
    }
}
