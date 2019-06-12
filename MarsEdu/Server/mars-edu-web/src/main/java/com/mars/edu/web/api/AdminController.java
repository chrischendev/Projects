package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.AdminEntity;
import com.mars.edu.web.model.xio.AdminXio;
import com.mars.edu.web.service.main.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 超级管理员 接口
 */
@RestController
@RequestMapping("/admin")
@Api(value = "admin", tags = "01. Admin", description = "超级管理员")
public class AdminController implements MarsBaseController<AdminEntity, AdminXio> {
    @Autowired
    AdminService adminService;

    @Override
    public BusinessHandler<AdminEntity, Integer, AdminXio> getBusinessHandler() {
        return new BusinessHandler(adminService, adminService);
    }
}



