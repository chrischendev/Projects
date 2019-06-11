package com.chris.school.api;

import com.chris.school.biz.SysParamsService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.SysParamsEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 系统参数 接口
 */
@Api(value = "系统参数", tags = "01. SysParams", description = "系统参数")
@RestController
@RequestMapping("/sysParams")
public class SysParamsController extends BaseAppController<SysParamsEntity, SysParamsService> {
    @Autowired
    SysParamsService service;

    @Override
    public SysParamsService service() {
        return service;
    }

}
