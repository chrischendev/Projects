package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.TeacherRepository;
import com.chris.school.model.orm.TeacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 教师 数据处理
 */
@Service
public class TeacherService extends BaseService<TeacherEntity, TeacherRepository> {
    @Provider
    @Override
    public TeacherEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<TeacherEntity> getAll() {
        return getList();
    }
}
