package com.mars.edu.web.service;

import com.mars.edu.web.dao.UserRepository;
import com.mars.edu.web.model.orm.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:29
 * Use for:
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public SysUserEntity reg(SysUserEntity user) {
        return userRepository.saveAndFlush(user);
    }

    public SysUserEntity getUser(String username, String password) {
        return userRepository.findFirstByNameAndPassword(username, password);
    }
}
