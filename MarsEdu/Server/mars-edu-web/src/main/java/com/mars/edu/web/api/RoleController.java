package com.mars.edu.web.api;

import com.mars.edu.web.dao.RoleDtoRepository;
import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.dto.RoleDto;
import com.mars.edu.web.model.orm.SysRoleEntity;
import com.mars.edu.web.model.xio.RoleXio;
import com.mars.edu.web.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:34
 * Use for:
 */
@RestController
@RequestMapping("/role")
@Api(value = "role", tags = "02. Role", description = "角色")
public class RoleController implements MarsBaseController<SysRoleEntity, RoleXio> {
    @Autowired
    RoleService roleService;
    @Autowired
    RoleDtoRepository roleDtoRepository;

    @Override
    public BusinessHandler<SysRoleEntity, Integer, RoleXio> getBusinessHandler() {
        return new BusinessHandler(roleService, roleService);
    }

    @GetMapping("/getRoleDtoList")
    @ApiOperation(value = "获取所有角色数据")
    public List<RoleDto> getRoleDtoList() {
        return roleDtoRepository.findAll();
    }

}
