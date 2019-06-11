package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ResRepository;
import com.chris.school.model.orm.ResEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 资源 数据处理
 */
@Service
public class ResService extends BaseService<ResEntity, ResRepository> {
    @Provider
    @Override
    public ResEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ResEntity> getAll() {
        return getList();
    }
}
