package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.SysParamsRepository;
import com.chris.school.model.orm.SysParamsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 系统参数 数据处理
 */
@Service
public class SysParamsService extends BaseService<SysParamsEntity, SysParamsRepository> {
    @Provider
    @Override
    public SysParamsEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<SysParamsEntity> getAll() {
        return getList();
    }
}
