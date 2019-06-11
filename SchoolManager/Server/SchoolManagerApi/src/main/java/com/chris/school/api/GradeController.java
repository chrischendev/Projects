package com.chris.school.api;

import com.chris.school.biz.GradeService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.GradeEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 年级 接口
 */
@Api(value = "年级", tags = "01. Grade", description = "年级")
@RestController
@RequestMapping("/grade")
public class GradeController extends BaseAppController<GradeEntity, GradeService> {
    @Autowired
    GradeService service;

    @Override
    public GradeService service() {
        return service;
    }

}
