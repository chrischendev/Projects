package com.chris.school.api;

import com.chris.school.biz.StuClassService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.StuClassEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 班级 接口
 */
@Api(value = "班级", tags = "01. StuClass", description = "班级")
@RestController
@RequestMapping("/stuClass")
public class StuClassController extends BaseAppController<StuClassEntity, StuClassService> {
    @Autowired
    StuClassService service;

    @Override
    public StuClassService service() {
        return service;
    }

}
