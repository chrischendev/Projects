package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SchoolAuthEntity;
import com.mars.edu.web.model.xio.SchoolAuthXio;
import com.mars.edu.web.service.main.SchoolAuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校授权码 接口
 */
@RestController
@RequestMapping("/schoolAuth")
@Api(value = "schoolAuth", tags = "10. SchoolAuth", description = "学校授权码")
public class SchoolAuthController implements MarsBaseController<SchoolAuthEntity, SchoolAuthXio> {
    @Autowired
    SchoolAuthService schoolAuthService;

    @Override
    public BusinessHandler<SchoolAuthEntity, Integer, SchoolAuthXio> getBusinessHandler() {
        return new BusinessHandler(schoolAuthService, schoolAuthService);
    }
}



