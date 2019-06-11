package com.mars.edu.web.api;

import com.mars.edu.web.converter.RoleAuthConverter;
import com.mars.edu.web.locallibs.base.BaseXlsProcess;
import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SysRoleAuthEntity;
import com.mars.edu.web.model.xio.RoleAuthXio;
import com.mars.edu.web.service.RoleAuthService;
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
@RequestMapping("/roleAuth")
@Api(value = "roleAuth", tags = "05. RoleAuth", description = "角色权限")
public class RoleAuthController implements MarsBaseController<SysRoleAuthEntity, RoleAuthXio> {
    @Autowired
    RoleAuthService roleAuthService;

    @Override
    public BusinessHandler<SysRoleAuthEntity, Integer, RoleAuthXio> getBusinessHandler() {
        return new BusinessHandler(roleAuthService, roleAuthService);
    }
}
