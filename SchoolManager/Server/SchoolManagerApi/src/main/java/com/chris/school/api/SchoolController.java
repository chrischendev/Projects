package com.chris.school.api;

import com.chris.school.biz.SchoolService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.SchoolEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 学校 接口
 */
@Api(value = "学校", tags = "01. School", description = "学校")
@RestController
@RequestMapping("/school")
public class SchoolController extends BaseAppController<SchoolEntity, SchoolService> {
    @Autowired
    SchoolService service;

    @Override
    public SchoolService service() {
        return service;
    }

}
