package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.StudentEntity;
import com.mars.edu.web.model.xio.StudentXio;
import com.mars.edu.web.service.main.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学生 接口
 */
@RestController
@RequestMapping("/student")
@Api(value = "student", tags = "19. Student", description = "学生")
public class StudentController implements MarsBaseController<StudentEntity, StudentXio> {
    @Autowired
    StudentService studentService;

    @Override
    public BusinessHandler<StudentEntity, Integer, StudentXio> getBusinessHandler() {
        return new BusinessHandler(studentService, studentService);
    }
}



