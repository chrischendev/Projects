package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.TeacherTeachRepository;
import com.chris.school.model.orm.TeacherTeachEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 授课教师 数据处理
 */
@Service
public class TeacherTeachService extends BaseService<TeacherTeachEntity, TeacherTeachRepository> {
    @Provider
    @Override
    public TeacherTeachEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<TeacherTeachEntity> getAll() {
        return getList();
    }
}
