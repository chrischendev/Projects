package com.mars.edu.web.service;

import com.mars.edu.web.dao.RoleAuthRepository;
import com.mars.edu.web.model.orm.SysRoleAuthEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 14:06
 * Use for:
 */
@Service
public class RoleAuthService {
    @PersistenceContext
    EntityManager em;

    @Autowired
    RoleAuthRepository roleAuthRepository;

    public boolean add(int roleId, int[] authIds) {
        for (int authId : authIds) {
            em.merge(new SysRoleAuthEntity(roleId, authId));
        }
        em.flush();
        em.clear();
        return true;
    }
}
