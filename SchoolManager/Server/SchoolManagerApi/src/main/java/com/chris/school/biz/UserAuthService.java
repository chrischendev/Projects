package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.UserAuthRepository;
import com.chris.school.model.orm.UserAuthEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 登录用户 数据处理
 */
@Service
public class UserAuthService extends BaseService<UserAuthEntity, UserAuthRepository> {
    @Provider
    @Override
    public UserAuthEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<UserAuthEntity> getAll() {
        return getList();
    }
}
