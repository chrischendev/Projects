package com.mars.edu.web.service;

import com.mars.edu.web.dao.UserRoleRepository;
import com.mars.edu.web.model.orm.SysUserRoleEntity;
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
public class UserRoleService {
    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRoleRepository userRoleRepository;

    public boolean add(int userId, int[] roleIds) {
        for (int roleId : roleIds) {
            em.merge(new SysUserRoleEntity(userId, roleId));
        }
        em.flush();
        em.clear();
        return true;
    }
}
