package com.mars.edu.web.api;

import com.mars.edu.web.dao.RoleDtoRepository;
import com.mars.edu.web.dao.RoleRepository;
import com.mars.edu.web.model.dto.RoleDto;
import com.mars.edu.web.model.orm.SysRoleEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class RoleController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleDtoRepository roleDtoRepository;

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public SysRoleEntity add(@RequestBody SysRoleEntity role) {
        return roleRepository.saveAndFlush(role);
    }

    @PostMapping("/getRoleDtoList")
    @ApiOperation(value = "获取所有角色数据")
    public List<RoleDto> getRoleDtoList() {
        return roleDtoRepository.findAll();
    }
}
