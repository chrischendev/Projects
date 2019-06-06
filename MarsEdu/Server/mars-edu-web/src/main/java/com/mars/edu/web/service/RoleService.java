package com.mars.edu.web.service;

import com.mars.edu.web.dao.RoleRepository;
import com.mars.edu.web.model.orm.SysRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 14:06
 * Use for:
 */
@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public SysRoleEntity addRole(SysRoleEntity role) {
        return roleRepository.saveAndFlush(role);
    }
}
