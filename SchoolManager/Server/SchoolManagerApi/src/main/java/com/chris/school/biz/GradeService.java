package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.GradeRepository;
import com.chris.school.model.orm.GradeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 年级 数据处理
 */
@Service
public class GradeService extends BaseService<GradeEntity, GradeRepository> {
    @Provider
    @Override
    public GradeEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<GradeEntity> getAll() {
        return getList();
    }
}
