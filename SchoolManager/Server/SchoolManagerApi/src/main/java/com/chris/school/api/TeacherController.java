package com.chris.school.api;

import com.chris.school.biz.TeacherService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.TeacherEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 教师 接口
 */
@Api(value = "教师", tags = "01. Teacher", description = "教师")
@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseAppController<TeacherEntity, TeacherService> {
    @Autowired
    TeacherService service;

    @Override
    public TeacherService service() {
        return service;
    }

}
