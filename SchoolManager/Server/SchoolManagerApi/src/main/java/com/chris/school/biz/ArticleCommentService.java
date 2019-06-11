package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ArticleCommentRepository;
import com.chris.school.model.orm.ArticleCommentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 文章评论 数据处理
 */
@Service
public class ArticleCommentService extends BaseService<ArticleCommentEntity, ArticleCommentRepository> {
    @Provider
    @Override
    public ArticleCommentEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ArticleCommentEntity> getAll() {
        return getList();
    }
}
