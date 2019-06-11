package com.mars.edu.web.dao;

import com.mars.edu.web.locallibs.mars.MarsBaseRepository;
import com.mars.edu.web.model.orm.SysUserEntity;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:25
 * Use for:
 */
public interface UserRepository extends MarsBaseRepository<SysUserEntity> {
    SysUserEntity findFirstByNameAndPassword(String username, String password);
}
