package com.chris.school.libs;

import com.chris.framework.builder.libs.springboot.controller.BaseBodySwaggerController;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.framework.builder.net.protocol.NetRequest;
import com.chris.school.utils.BizUtils;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * YdxProvider
 * com.ydx.provider.libs
 * Created by Chris Chen
 * 2018/2/28
 * Explain:
 */
public abstract class BaseAppController<T, S extends BaseService> extends BaseBodySwaggerController<T, S> {

    @Override
    public Integer add(@RequestBody NetRequest<T> entity) {
        BizUtils.setDefaultValue(entity, "available", new Byte(String.valueOf(0)));
        return service.addOne(entity);
    }
}
