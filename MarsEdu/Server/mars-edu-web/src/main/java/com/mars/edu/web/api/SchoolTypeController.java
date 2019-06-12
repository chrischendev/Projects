package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SchoolTypeEntity;
import com.mars.edu.web.model.xio.SchoolTypeXio;
import com.mars.edu.web.service.main.SchoolTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校类型 接口
 */
@RestController
@RequestMapping("/schoolType")
@Api(value = "schoolType", tags = "09. SchoolType", description = "学校类型")
public class SchoolTypeController implements MarsBaseController<SchoolTypeEntity, SchoolTypeXio> {
    @Autowired
    SchoolTypeService schoolTypeService;

    @Override
    public BusinessHandler<SchoolTypeEntity, Integer, SchoolTypeXio> getBusinessHandler() {
        return new BusinessHandler(schoolTypeService, schoolTypeService);
    }
}



