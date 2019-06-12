package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SchoolInfoEntity;
import com.mars.edu.web.model.xio.SchoolInfoXio;
import com.mars.edu.web.service.main.SchoolInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校信息 接口
 */
@RestController
@RequestMapping("/schoolInfo")
@Api(value = "schoolInfo", tags = "10. SchoolInfo", description = "学校信息")
public class SchoolInfoController implements MarsBaseController<SchoolInfoEntity, SchoolInfoXio> {
    @Autowired
    SchoolInfoService schoolInfoService;

    @Override
    public BusinessHandler<SchoolInfoEntity, Integer, SchoolInfoXio> getBusinessHandler() {
        return new BusinessHandler(schoolInfoService, schoolInfoService);
    }
}



