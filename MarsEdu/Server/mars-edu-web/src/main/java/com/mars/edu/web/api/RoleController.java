package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.RoleEntity;
import com.mars.edu.web.model.xio.RoleXio;
import com.mars.edu.web.service.main.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 角色 接口
 */
@RestController
@RequestMapping("/role")
@Api(value = "role", tags = "03. Role", description = "角色")
public class RoleController implements MarsBaseController<RoleEntity, RoleXio> {
    @Autowired
    RoleService roleService;

    @Override
    public BusinessHandler<RoleEntity, Integer, RoleXio> getBusinessHandler() {
        return new BusinessHandler(roleService, roleService);
    }
}



