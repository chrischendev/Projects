package com.chris.school.api;

import com.chris.school.biz.ResTypeService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ResTypeEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 资源类型 接口
 */
@Api(value = "资源类型", tags = "01. ResType", description = "资源类型")
@RestController
@RequestMapping("/resType")
public class ResTypeController extends BaseAppController<ResTypeEntity, ResTypeService> {
    @Autowired
    ResTypeService service;

    @Override
    public ResTypeService service() {
        return service;
    }

}
