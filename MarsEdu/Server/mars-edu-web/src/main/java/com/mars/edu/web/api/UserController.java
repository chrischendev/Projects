package com.mars.edu.web.api;

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
public class UserController implements MarsBaseController<SysUserEntity, UserXio> {
    @Autowired
    UserService userService;
    @Autowired
    UserDtoRepository userDtoRepository;
    @Autowired
    UserConverter userConverter;

    @Override
    public BusinessHandler<SysUserEntity, Integer, UserXio> getBusinessHandler() {
        return new BusinessHandler(userService, userService);
    }

    @PostMapping("/reg")
    @ApiOperation(value = "注册")
    public ResponseEntity<?> reg(@RequestBody SysUserEntity user) {
        return ResponseEntity.ok().body(userService.add(user));
    }

    @ResponseBody
    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseEntity<?> login(String username, String password) {
        String result = null != userService.findUserByUsernameAndPassword(username, password) ? "login success!" : "login failed.";
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getUserDtoList")
    @ApiOperation(value = "获取所有用户数据")
    public ResponseEntity<?> getUserDtoList() {
        List<UserDto> userDtoList = userDtoRepository.findAll();
        return ResponseEntity.ok().body(userDtoList);
    }
}



