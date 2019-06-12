package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.AuthEntity;
import com.mars.edu.web.model.xio.AuthXio;
import com.mars.edu.web.service.main.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 权限 接口
 */
@RestController
@RequestMapping("/auth")
@Api(value = "auth", tags = "04. Auth", description = "权限")
public class AuthController implements MarsBaseController<AuthEntity, AuthXio> {
    @Autowired
    AuthService authService;

    @Override
    public BusinessHandler<AuthEntity, Integer, AuthXio> getBusinessHandler() {
        return new BusinessHandler(authService, authService);
    }
}



