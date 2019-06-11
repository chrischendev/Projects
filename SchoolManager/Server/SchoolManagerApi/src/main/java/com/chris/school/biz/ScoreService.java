package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ScoreRepository;
import com.chris.school.model.orm.ScoreEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 成绩 数据处理
 */
@Service
public class ScoreService extends BaseService<ScoreEntity, ScoreRepository> {
    @Provider
    @Override
    public ScoreEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ScoreEntity> getAll() {
        return getList();
    }
}
