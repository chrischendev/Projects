package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.StudentRepository;
import com.chris.school.model.orm.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 学生 数据处理
 */
@Service
public class StudentService extends BaseService<StudentEntity, StudentRepository> {
    @Provider
    @Override
    public StudentEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<StudentEntity> getAll() {
        return getList();
    }
}
