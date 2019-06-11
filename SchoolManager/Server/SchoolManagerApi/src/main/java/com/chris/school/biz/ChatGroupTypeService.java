package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ChatGroupTypeRepository;
import com.chris.school.model.orm.ChatGroupTypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 聊天室类型 数据处理
 */
@Service
public class ChatGroupTypeService extends BaseService<ChatGroupTypeEntity, ChatGroupTypeRepository> {
    @Provider
    @Override
    public ChatGroupTypeEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ChatGroupTypeEntity> getAll() {
        return getList();
    }
}
