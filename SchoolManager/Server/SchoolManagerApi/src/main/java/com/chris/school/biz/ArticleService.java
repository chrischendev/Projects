package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ArticleRepository;
import com.chris.school.model.orm.ArticleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 文章 数据处理
 */
@Service
public class ArticleService extends BaseService<ArticleEntity, ArticleRepository> {
    @Provider
    @Override
    public ArticleEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ArticleEntity> getAll() {
        return getList();
    }
}
