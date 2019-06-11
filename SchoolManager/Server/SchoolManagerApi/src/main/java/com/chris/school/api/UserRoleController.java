package com.chris.school.api;

import com.chris.school.biz.UserRoleService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.UserRoleEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 用户角色 接口
 */
@Api(value = "用户角色", tags = "01. UserRole", description = "用户角色")
@RestController
@RequestMapping("/userRole")
public class UserRoleController extends BaseAppController<UserRoleEntity, UserRoleService> {
    @Autowired
    UserRoleService service;

    @Override
    public UserRoleService service() {
        return service;
    }

}
