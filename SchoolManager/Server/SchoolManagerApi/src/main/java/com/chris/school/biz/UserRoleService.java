package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.UserRoleRepository;
import com.chris.school.model.orm.UserRoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 用户角色 数据处理
 */
@Service
public class UserRoleService extends BaseService<UserRoleEntity, UserRoleRepository> {
    @Provider
    @Override
    public UserRoleEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<UserRoleEntity> getAll() {
        return getList();
    }
}
