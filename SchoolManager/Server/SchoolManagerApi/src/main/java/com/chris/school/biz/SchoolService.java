package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.SchoolRepository;
import com.chris.school.model.orm.SchoolEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 学校 数据处理
 */
@Service
public class SchoolService extends BaseService<SchoolEntity, SchoolRepository> {
    @Provider
    @Override
    public SchoolEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<SchoolEntity> getAll() {
        return getList();
    }
}
