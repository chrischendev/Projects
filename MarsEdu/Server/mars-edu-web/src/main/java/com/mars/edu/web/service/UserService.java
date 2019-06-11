package com.mars.edu.web.service;

import com.mars.edu.web.dao.UserRepository;
import com.mars.edu.web.locallibs.base.BaseService;
import com.mars.edu.web.locallibs.mars.MarsBaseService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.model.orm.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:29
 * Use for: 基本service封装
 */
@Service
public class UserService implements UserDetailsService, MarsBaseService<SysUserEntity> {
    @Autowired
    EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public DataSourceHandler<SysUserEntity, Integer> getDataSourceHandler() {
        return new DataSourceHandler<>(em, userRepository,new SysUserEntity());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //todo 从数据库中验证
        return new User(username, passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));
    }

    public SysUserEntity findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findFirstByNameAndPassword(username, password);
    }

}
