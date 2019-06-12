package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.UserRoleEntity;
import com.mars.edu.web.model.xio.UserRoleXio;
import com.mars.edu.web.service.main.UserRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户角色关联 接口
 */
@RestController
@RequestMapping("/userRole")
@Api(value = "userRole", tags = "05. UserRole", description = "用户角色关联")
public class UserRoleController implements MarsBaseController<UserRoleEntity, UserRoleXio> {
    @Autowired
    UserRoleService userRoleService;

    @Override
    public BusinessHandler<UserRoleEntity, Integer, UserRoleXio> getBusinessHandler() {
        return new BusinessHandler(userRoleService, userRoleService);
    }
}



