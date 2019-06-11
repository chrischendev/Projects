package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SysUserRoleEntity;
import com.mars.edu.web.model.xio.UserRoleXio;
import com.mars.edu.web.service.UserRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:34
 * Use for:
 */
@RestController
@RequestMapping("/userRole")
@Api(value = "userRole", tags = "03. UserRole", description = "用户角色")
public class UserRoleController implements MarsBaseController<SysUserRoleEntity, UserRoleXio> {
    @Autowired
    UserRoleService userRoleService;

    @Override
    public BusinessHandler<SysUserRoleEntity, Integer, UserRoleXio> getBusinessHandler() {
        return new BusinessHandler(userRoleService, userRoleService);
    }
}
