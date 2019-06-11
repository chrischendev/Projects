package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ResTypeRepository;
import com.chris.school.model.orm.ResTypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 资源类型 数据处理
 */
@Service
public class ResTypeService extends BaseService<ResTypeEntity, ResTypeRepository> {
    @Provider
    @Override
    public ResTypeEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ResTypeEntity> getAll() {
        return getList();
    }
}
