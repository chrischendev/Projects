package com.chris.school.api;

import com.chris.school.biz.UserAuthService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.UserAuthEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 登录用户 接口
 */
@Api(value = "登录用户", tags = "01. UserAuth", description = "登录用户")
@RestController
@RequestMapping("/userAuth")
public class UserAuthController extends BaseAppController<UserAuthEntity, UserAuthService> {
    @Autowired
    UserAuthService service;

    @Override
    public UserAuthService service() {
        return service;
    }

}
