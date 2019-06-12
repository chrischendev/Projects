package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SchoolClassEntity;
import com.mars.edu.web.model.xio.SchoolClassXio;
import com.mars.edu.web.service.main.SchoolClassService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 班级 接口
 */
@RestController
@RequestMapping("/schoolClass")
@Api(value = "schoolClass", tags = "16. SchoolClass", description = "班级")
public class SchoolClassController implements MarsBaseController<SchoolClassEntity, SchoolClassXio> {
    @Autowired
    SchoolClassService schoolClassService;

    @Override
    public BusinessHandler<SchoolClassEntity, Integer, SchoolClassXio> getBusinessHandler() {
        return new BusinessHandler(schoolClassService, schoolClassService);
    }
}



