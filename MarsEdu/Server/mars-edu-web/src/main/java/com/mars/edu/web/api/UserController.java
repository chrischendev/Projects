package com.mars.edu.web.api;

import com.google.gson.Gson;
import com.mars.edu.web.converter.UserConverter;
import com.mars.edu.web.dao.UserDtoRepository;
import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.dto.UserDto;
import com.mars.edu.web.model.orm.SysUserEntity;
import com.mars.edu.web.model.xio.UserXio;
import com.mars.edu.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class UserController implements MarsBaseController<SysUserEntity, Integer, UserXio> {
    @Autowired
    UserService userService;
    @Autowired
    UserConverter userConverter;
    @Autowired
    UserDtoRepository userDtoRepository;
    @Autowired
    Gson gson;

    @Override
    public BusinessHandler<SysUserEntity, Integer, UserXio> getBusinessHandler() {
        return new BusinessHandler(userService, UserXio.class, userConverter);
    }

    @PostMapping("/reg")
    @ApiOperation(value = "注册")
    public SysUserEntity reg(@RequestBody SysUserEntity user) {
        return userService.reg(user);
    }

    @ResponseBody
    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public String login(String username, String password) {
        return null != userService.findUserByUsernameAndPassword(username, password) ? "login success!" : "login failed.";
    }

    @GetMapping("/getUserDtoList")
    @ApiOperation(value = "获取所有用户数据")
    public ResponseEntity<?> getUserDtoList() {
        List<UserDto> userDtoList = userDtoRepository.findAll();
        System.out.println(gson.toJson(userDtoList));
        return ResponseEntity.ok().body(userDtoList);
    }
}


