package com.chris.school.api;

import com.chris.school.biz.TeacherTeachService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.TeacherTeachEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 授课教师 接口
 */
@Api(value = "授课教师", tags = "01. TeacherTeach", description = "授课教师")
@RestController
@RequestMapping("/teacherTeach")
public class TeacherTeachController extends BaseAppController<TeacherTeachEntity, TeacherTeachService> {
    @Autowired
    TeacherTeachService service;

    @Override
    public TeacherTeachService service() {
        return service;
    }

}
