package com.mars.edu.web.api;

import com.mars.edu.web.locallibs.mars.MarsBaseController;
import com.mars.edu.web.locallibs.model.BusinessHandler;
import com.mars.edu.web.model.orm.SchoolGradeEntity;
import com.mars.edu.web.model.xio.SchoolGradeXio;
import com.mars.edu.web.service.main.SchoolGradeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 年级 接口
 */
@RestController
@RequestMapping("/schoolGrade")
@Api(value = "schoolGrade", tags = "15. SchoolGrade", description = "年级")
public class SchoolGradeController implements MarsBaseController<SchoolGradeEntity, SchoolGradeXio> {
    @Autowired
    SchoolGradeService schoolGradeService;

    @Override
    public BusinessHandler<SchoolGradeEntity, Integer, SchoolGradeXio> getBusinessHandler() {
        return new BusinessHandler(schoolGradeService, schoolGradeService);
    }
}



