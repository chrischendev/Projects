package com.mars.edu.web.service;

import com.mars.edu.web.dao.UserRepository;
import com.mars.edu.web.locallibs.base.BaseService;
import com.mars.edu.web.model.orm.SysUserEntity;
import com.mars.edu.web.model.xio.UserXio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:29
 * Use for: 基本service封装
 */
@Service
public class UserService implements UserDetailsService, BaseService<SysUserEntity, Integer, UserRepository> {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EntityManager em;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public SysUserEntity createEntity() {
        return new SysUserEntity();
    }

    @Override
    public SysUserEntity addId(SysUserEntity entity, Integer integer) {
        entity.setId(integer);
        return entity;
    }

    @Override
    public boolean existId(SysUserEntity entity) {
        return entity.getId() > 0;
    }

    public SysUserEntity reg(SysUserEntity user) {
        return userRepository.saveAndFlush(user);
    }

    public boolean addXioList(List<UserXio> userVioList) {
        return addBatch(userVioList.stream().map(userXio -> {
            SysUserEntity userEntity = new SysUserEntity();
            BeanUtils.copyProperties(userXio, userEntity);
            return userEntity;
        }).collect(Collectors.toList()));
    }

    public SysUserEntity findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findFirstByNameAndPassword(username, password);
    }

}
