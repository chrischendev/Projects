package com.mars.edu.web.service;

import com.mars.edu.web.dao.AuthRepository;
import com.mars.edu.web.model.orm.SysAuthEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 14:44
 * Use for:
 */
@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;

    public SysAuthEntity addAuth(SysAuthEntity auth) {
        return authRepository.saveAndFlush(auth);
    }
}
