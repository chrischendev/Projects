package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SubjectEntity;
import com.mars.edu.web.model.xio.SubjectXio;
import com.mars.edu.web.service.main.SubjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学科 接口
 */
@RestController
@RequestMapping("/subject")
@Api(value = "subject", tags = "14. Subject", description = "学科")
public class SubjectController implements MarsBaseController<SubjectEntity, SubjectXio> {
    @Autowired
    SubjectService subjectService;

    @Override
    public BusinessHandler<SubjectEntity, Integer, SubjectXio> getBusinessHandler() {
        return new BusinessHandler(subjectService, subjectService);
    }
}



