package com.chris.school.api;

import com.chris.school.biz.ArticleService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ArticleEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 文章 接口
 */
@Api(value = "文章", tags = "01. Article", description = "文章")
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseAppController<ArticleEntity, ArticleService> {
    @Autowired
    ArticleService service;

    @Override
    public ArticleService service() {
        return service;
    }

}
