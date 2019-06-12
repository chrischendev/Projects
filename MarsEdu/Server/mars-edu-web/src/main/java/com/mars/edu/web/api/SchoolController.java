package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SchoolEntity;
import com.mars.edu.web.model.xio.SchoolXio;
import com.mars.edu.web.service.main.SchoolService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校 接口
 */
@RestController
@RequestMapping("/school")
@Api(value = "school", tags = "08. School", description = "学校")
public class SchoolController implements MarsBaseController<SchoolEntity, SchoolXio> {
    @Autowired
    SchoolService schoolService;

    @Override
    public BusinessHandler<SchoolEntity, Integer, SchoolXio> getBusinessHandler() {
        return new BusinessHandler(schoolService, schoolService);
    }
}



