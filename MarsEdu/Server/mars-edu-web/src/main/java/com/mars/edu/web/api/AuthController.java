package com.mars.edu.web.api;

import com.mars.edu.web.dao.AuthRepository;
import com.mars.edu.web.model.orm.SysAuthEntity;
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
@RequestMapping("/auth")
@Api(value = "auth", tags = "04. Auth", description = "权限")
public class AuthController {
    @Autowired
    AuthRepository authRepository;

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public SysAuthEntity reg(@RequestBody SysAuthEntity auth) {
        return authRepository.saveAndFlush(auth);
    }


}
