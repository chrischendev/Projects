package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.StuClassRepository;
import com.chris.school.model.orm.StuClassEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 班级 数据处理
 */
@Service
public class StuClassService extends BaseService<StuClassEntity, StuClassRepository> {
    @Provider
    @Override
    public StuClassEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<StuClassEntity> getAll() {
        return getList();
    }
}
