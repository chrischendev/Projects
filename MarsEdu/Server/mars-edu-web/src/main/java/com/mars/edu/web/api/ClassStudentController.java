package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.ClassStudentEntity;
import com.mars.edu.web.model.xio.ClassStudentXio;
import com.mars.edu.web.service.main.ClassStudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 班级学生 接口
 */
@RestController
@RequestMapping("/classStudent")
@Api(value = "classStudent", tags = "17. ClassStudent", description = "班级学生")
public class ClassStudentController implements MarsBaseController<ClassStudentEntity, ClassStudentXio> {
    @Autowired
    ClassStudentService classStudentService;

    @Override
    public BusinessHandler<ClassStudentEntity, Integer, ClassStudentXio> getBusinessHandler() {
        return new BusinessHandler(classStudentService, classStudentService);
    }
}



