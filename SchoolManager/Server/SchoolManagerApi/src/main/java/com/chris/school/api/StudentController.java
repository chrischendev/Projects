package com.chris.school.api;

import com.chris.school.biz.StudentService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.StudentEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 学生 接口
 */
@Api(value = "学生", tags = "01. Student", description = "学生")
@RestController
@RequestMapping("/student")
public class StudentController extends BaseAppController<StudentEntity, StudentService> {
    @Autowired
    StudentService service;

    @Override
    public StudentService service() {
        return service;
    }

}
