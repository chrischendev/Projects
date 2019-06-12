package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.StaffEntity;
import com.mars.edu.web.model.xio.StaffXio;
import com.mars.edu.web.service.main.StaffService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 教职工 接口
 */
@RestController
@RequestMapping("/staff")
@Api(value = "staff", tags = "13. Staff", description = "教职工")
public class StaffController implements MarsBaseController<StaffEntity, StaffXio> {
    @Autowired
    StaffService staffService;

    @Override
    public BusinessHandler<StaffEntity, Integer, StaffXio> getBusinessHandler() {
        return new BusinessHandler(staffService, staffService);
    }
}



