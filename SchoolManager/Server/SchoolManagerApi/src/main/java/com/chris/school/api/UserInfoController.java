package com.chris.school.api;

import com.chris.school.biz.UserInfoService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.UserInfoEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 用户信息 接口
 */
@Api(value = "用户信息", tags = "01. UserInfo", description = "用户信息")
@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends BaseAppController<UserInfoEntity, UserInfoService> {
    @Autowired
    UserInfoService service;

    @Override
    public UserInfoService service() {
        return service;
    }

}
