package com.mars.edu.web.api;

import com.mars.edu.web.dao.UserDtoRepository;
import com.mars.edu.web.model.dto.UserDto;
import com.mars.edu.web.model.orm.SysUserEntity;
import com.mars.edu.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:34
 * Use for:
 */
@RestController
@RequestMapping("/user")
@Api(value = "user", tags = "01. User", description = "用户")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDtoRepository userDtoRepository;

    @PostMapping("/reg")
    @ApiOperation(value = "注册")
    public SysUserEntity reg(@RequestBody SysUserEntity user) {
        return userService.reg(user);
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public String login(String username, String password) {
        return null != userService.getUser(username, password) ? "login success!" : "login failed.";
    }

    @PostMapping("/getUserDtoList")
    @ApiOperation(value = "获取所有用户数据")
    public List<UserDto> getUserDtoList() {
        return userDtoRepository.findAll();
    }
}
