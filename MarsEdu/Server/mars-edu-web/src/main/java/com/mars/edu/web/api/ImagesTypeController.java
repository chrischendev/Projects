package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.ImagesTypeEntity;
import com.mars.edu.web.model.xio.ImagesTypeXio;
import com.mars.edu.web.service.main.ImagesTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 图片类型 接口
 */
@RestController
@RequestMapping("/imagesType")
@Api(value = "imagesType", tags = "20. ImagesType", description = "图片类型")
public class ImagesTypeController implements MarsBaseController<ImagesTypeEntity, ImagesTypeXio> {
    @Autowired
    ImagesTypeService imagesTypeService;

    @Override
    public BusinessHandler<ImagesTypeEntity, Integer, ImagesTypeXio> getBusinessHandler() {
        return new BusinessHandler(imagesTypeService, imagesTypeService);
    }
}



