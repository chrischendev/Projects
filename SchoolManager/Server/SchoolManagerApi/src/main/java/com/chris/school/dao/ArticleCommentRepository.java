package com.chris.school.dao;

import com.chris.framework.builder.libs.springboot.repository.BaseRepository;
import com.chris.school.model.orm.ArticleCommentEntity;

/**
 * SchoolManagerApi
 * com.chris.school.dao
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 文章评论 数据访问
 */
public interface ArticleCommentRepository extends BaseRepository<ArticleCommentEntity> {
}
