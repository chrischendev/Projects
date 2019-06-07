package com.mars.edu.web.service;

import com.mars.edu.web.dao.UserRepository;
import com.mars.edu.web.model.orm.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:29
 * Use for:
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public SysUserEntity reg(SysUserEntity user) {
        return userRepository.saveAndFlush(user);
    }

    public SysUserEntity getUser(String username, String password) {
        return userRepository.findFirstByNameAndPassword(username, password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));
    }
}
