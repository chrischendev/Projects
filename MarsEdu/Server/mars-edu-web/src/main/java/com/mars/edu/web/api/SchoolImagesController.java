package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SchoolImagesEntity;
import com.mars.edu.web.model.xio.SchoolImagesXio;
import com.mars.edu.web.service.main.SchoolImagesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学校图片 接口
 */
@RestController
@RequestMapping("/schoolImages")
@Api(value = "schoolImages", tags = "11. SchoolImages", description = "学校图片")
public class SchoolImagesController implements MarsBaseController<SchoolImagesEntity, SchoolImagesXio> {
    @Autowired
    SchoolImagesService schoolImagesService;

    @Override
    public BusinessHandler<SchoolImagesEntity, Integer, SchoolImagesXio> getBusinessHandler() {
        return new BusinessHandler(schoolImagesService, schoolImagesService);
    }
}



