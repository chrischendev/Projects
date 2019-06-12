package com.mars.edu.web.dao.repository;

import com.mars.edu.web.locallibs.mars.MarsBaseRepository;
import com.mars.edu.web.model.orm.UserEntity;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:25
 * Use for: 用户
 */
public interface UserRepository extends MarsBaseRepository<UserEntity> {
    UserEntity findFirstByNameAndPassword(String username, String password);
}
