package com.mars.edu.web.api;

import com.chris.poi.xls.XlsDataWorkBook;
import com.chris.poi.xls.XlsUtils;
import com.google.gson.Gson;
import com.mars.edu.web.dao.UserDtoRepository;
import com.mars.edu.web.mapstruct.UserMapper;
import com.mars.edu.web.model.dto.UserDto;
import com.mars.edu.web.model.orm.SysUserEntity;
import com.mars.edu.web.model.xio.UserXio;
import com.mars.edu.web.service.UserService;
import com.mars.edu.web.utils.LocalXlsUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @Autowired
    UserMapper userMapper;
    @Autowired
    Gson gson;

    @PostMapping("/reg")
    @ApiOperation(value = "注册")
    public SysUserEntity reg(@RequestBody SysUserEntity user) {
        return userService.reg(user);
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public String login(String username, String password) {
        return null != userService.findUserByUsernameAndPassword(username, password) ? "login success!" : "login failed.";
    }

    @GetMapping("/getUserDtoList")
    @ApiOperation(value = "获取所有用户数据")
    public List<UserDto> getUserDtoList() {
        return userDtoRepository.findAll();
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public String exportUsers(HttpServletResponse response) {
        XlsDataWorkBook workBook = XlsDataWorkBook.get()
                .addDataList(UserXio.class, "用户", userMapper.toDtoList(userService.findAll()));
        LocalXlsUtils.writeToResponse("user", response, workBook);
        return "export success.";
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public String importUsers(@RequestPart("file") MultipartFile file) throws IOException, IllegalAccessException, InstantiationException {
        List<UserXio> userXioList = XlsUtils.readXlsxFromInputStream(file.getInputStream(), UserXio.class);
        System.out.println(gson.toJson(userXioList));
        return userService.addXioList(userXioList) ? "import success." : "import failed.";
    }

}
