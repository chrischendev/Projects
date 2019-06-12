package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.UserInfoEntity;
import com.mars.edu.web.model.xio.UserInfoXio;
import com.mars.edu.web.service.main.UserInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 用户信息 接口
 */
@RestController
@RequestMapping("/userInfo")
@Api(value = "userInfo", tags = "07. UserInfo", description = "用户信息")
public class UserInfoController implements MarsBaseController<UserInfoEntity, UserInfoXio> {
    @Autowired
    UserInfoService userInfoService;

    @Override
    public BusinessHandler<UserInfoEntity, Integer, UserInfoXio> getBusinessHandler() {
        return new BusinessHandler(userInfoService, userInfoService);
    }
}



