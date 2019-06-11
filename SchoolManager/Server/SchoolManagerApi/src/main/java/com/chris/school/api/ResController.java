package com.chris.school.api;

import com.chris.school.biz.ResService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ResEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 资源 接口
 */
@Api(value = "资源", tags = "01. Res", description = "资源")
@RestController
@RequestMapping("/res")
public class ResController extends BaseAppController<ResEntity, ResService> {
    @Autowired
    ResService service;

    @Override
    public ResService service() {
        return service;
    }

}
