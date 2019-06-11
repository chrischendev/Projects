package com.chris.school.api;

import com.chris.school.biz.SubjectService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.SubjectEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 学科 接口
 */
@Api(value = "学科", tags = "01. Subject", description = "学科")
@RestController
@RequestMapping("/subject")
public class SubjectController extends BaseAppController<SubjectEntity, SubjectService> {
    @Autowired
    SubjectService service;

    @Override
    public SubjectService service() {
        return service;
    }

}
