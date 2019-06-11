package com.chris.school.api;

import com.chris.school.biz.ScoreService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ScoreEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 成绩 接口
 */
@Api(value = "成绩", tags = "01. Score", description = "成绩")
@RestController
@RequestMapping("/score")
public class ScoreController extends BaseAppController<ScoreEntity, ScoreService> {
    @Autowired
    ScoreService service;

    @Override
    public ScoreService service() {
        return service;
    }

}
