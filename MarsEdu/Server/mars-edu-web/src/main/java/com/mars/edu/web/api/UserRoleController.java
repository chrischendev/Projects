package com.mars.edu.web.api;

import com.mars.edu.web.dao.UserRoleRepository;
import com.mars.edu.web.model.orm.SysUserRoleEntity;
import com.mars.edu.web.service.RoleAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class UserRoleController {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    RoleAuthService roleAuthService;

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public SysUserRoleEntity add(@RequestBody SysUserRoleEntity userRole) {
        return userRoleRepository.saveAndFlush(userRole);
    }

    @PostMapping("/addBatch")
    @ApiOperation(value = "批量添加")
    public Boolean addBatch(int userId, int[] roleIds) {
        return roleAuthService.add(userId, roleIds);
    }


}
