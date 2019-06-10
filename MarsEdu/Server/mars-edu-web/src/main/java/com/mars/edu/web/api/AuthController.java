package com.mars.edu.web.api;

import com.mars.edu.web.converter.AuthConverter;
import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SysAuthEntity;
import com.mars.edu.web.model.xio.AuthXio;
import com.mars.edu.web.service.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthController implements MarsBaseController<SysAuthEntity, Integer, AuthXio> {
    @Autowired
    AuthService authService;
    @Autowired
    AuthConverter authConverter;

    @Override
    public BusinessHandler<SysAuthEntity, Integer, AuthXio> getBusinessHandler() {
        return new BusinessHandler(authService, AuthXio.class, authConverter);
    }
}
