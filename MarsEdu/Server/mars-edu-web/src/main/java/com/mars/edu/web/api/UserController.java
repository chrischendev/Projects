package com.mars.edu.web.api;

import com.mars.edu.web.config.enhance.IncludeHeader;
import com.mars.edu.web.dao.repository.UserDtoRepository;
import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.dto.UserDto;
import com.mars.edu.web.model.orm.UserEntity;
import com.mars.edu.web.model.xio.UserXio;
import com.mars.edu.web.service.main.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户 接口
 */
@RestController
@RequestMapping("/user")
@Api(value = "user", tags = "02. User", description = "用户")
public class UserController implements MarsBaseController<UserEntity, UserXio> {
    @Autowired
    UserService userService;
    @Autowired
    UserDtoRepository userDtoRepository;

    @Override
    public BusinessHandler<UserEntity, Integer, UserXio> getBusinessHandler() {
        return new BusinessHandler(userService, userService);
    }


    @PostMapping("/reg")
    @ApiOperation(value = "注册")
    public ResponseEntity<?> reg(@RequestBody UserEntity user) {
        return ResponseEntity.ok().body(userService.add(user));
    }

    @ResponseBody
    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseEntity<?> login(String username, String password) {
        String result = null != userService.findUserByUsernameAndPassword(username, password) ? "login success!" : "login failed.";
        return ResponseEntity.ok().body(result);
    }

    //@IncludeHeader
    @GetMapping("/getUserDtoList")
    @ApiOperation(value = "获取所有用户数据")
    public ResponseEntity<?> getUserDtoList() {
        List<UserDto> userDtoList = userDtoRepository.findAll();
        return ResponseEntity.ok().header("info","Hello,World!").body(userDtoList);
    }
}



