package com.chris.school.api;

import com.chris.school.biz.AdminService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.AdminEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 管理员 接口
 */
@Api(value = "管理员", tags = "01. Admin", description = "管理员")
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseAppController<AdminEntity, AdminService> {
    @Autowired
    AdminService service;

    @Override
    public AdminService service() {
        return service;
    }

}
