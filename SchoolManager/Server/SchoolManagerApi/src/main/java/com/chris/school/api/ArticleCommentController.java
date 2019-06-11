package com.chris.school.api;

import com.chris.school.biz.ArticleCommentService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ArticleCommentEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 文章评论 接口
 */
@Api(value = "文章评论", tags = "01. ArticleComment", description = "文章评论")
@RestController
@RequestMapping("/articleComment")
public class ArticleCommentController extends BaseAppController<ArticleCommentEntity, ArticleCommentService> {
    @Autowired
    ArticleCommentService service;

    @Override
    public ArticleCommentService service() {
        return service;
    }

}
