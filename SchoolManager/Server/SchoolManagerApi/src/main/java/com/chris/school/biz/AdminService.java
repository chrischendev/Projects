package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.AdminRepository;
import com.chris.school.model.orm.AdminEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 管理员 数据处理
 */
@Service
public class AdminService extends BaseService<AdminEntity, AdminRepository> {
    @Provider
    @Override
    public AdminEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<AdminEntity> getAll() {
        return getList();
    }
}
