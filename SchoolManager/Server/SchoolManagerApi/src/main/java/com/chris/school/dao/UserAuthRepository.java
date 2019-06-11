package com.chris.school.dao;

import com.chris.framework.builder.libs.springboot.repository.BaseRepository;
import com.chris.school.model.orm.UserAuthEntity;

/**
 * SchoolManagerApi
 * com.chris.school.dao
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 登录用户 数据访问
 */
public interface UserAuthRepository extends BaseRepository<UserAuthEntity> {
}
