package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.RoleAuthEntity;
import com.mars.edu.web.model.xio.RoleAuthXio;
import com.mars.edu.web.service.main.RoleAuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 角色权限关联 接口
 */
@RestController
@RequestMapping("/roleAuth")
@Api(value = "roleAuth", tags = "06. RoleAuth", description = "角色权限关联")
public class RoleAuthController implements MarsBaseController<RoleAuthEntity, RoleAuthXio> {
    @Autowired
    RoleAuthService roleAuthService;

    @Override
    public BusinessHandler<RoleAuthEntity, Integer, RoleAuthXio> getBusinessHandler() {
        return new BusinessHandler(roleAuthService, roleAuthService);
    }
}



