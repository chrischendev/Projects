package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.SubjectRepository;
import com.chris.school.model.orm.SubjectEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 学科 数据处理
 */
@Service
public class SubjectService extends BaseService<SubjectEntity, SubjectRepository> {
    @Provider
    @Override
    public SubjectEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<SubjectEntity> getAll() {
        return getList();
    }
}
