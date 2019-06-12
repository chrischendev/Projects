package com.mars.edu.web.service.main;

import com.mars.edu.web.converter.UserConverter;
import com.mars.edu.web.dao.repository.UserRepository;
import com.mars.edu.web.locallibs.mars.DataSourceHandlerBox;
import com.mars.edu.web.locallibs.mars.MarsXlsService;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import com.mars.edu.web.model.orm.UserEntity;
import com.mars.edu.web.model.xio.UserXio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户 主要业务处理
 * 包含XLSX导入导出功能
 */
@Service
@Transactional
public class UserService implements UserDetailsService, MarsXlsService<UserEntity, UserXio> {
    @Autowired
    EntityManager entityManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public DataSourceHandlerBox<UserEntity, UserXio> getDataSourceHandlerBox() {
        return new DataSourceHandlerBox(new DataSourceHandler<>(entityManager, userRepository, new UserEntity()),
                new XlsProcessHandler(this, userConverter, UserXio.class));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //todo 从数据库中验证
        return new User(username, passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));
    }

    public UserEntity findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findFirstByNameAndPassword(username, password);
    }

}
