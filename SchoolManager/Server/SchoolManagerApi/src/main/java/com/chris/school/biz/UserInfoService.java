package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.UserInfoRepository;
import com.chris.school.model.orm.UserInfoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 用户信息 数据处理
 */
@Service
public class UserInfoService extends BaseService<UserInfoEntity, UserInfoRepository> {
    @Provider
    @Override
    public UserInfoEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<UserInfoEntity> getAll() {
        return getList();
    }
}
