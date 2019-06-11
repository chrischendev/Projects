package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ChatGroupRepository;
import com.chris.school.model.orm.ChatGroupEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 聊天群 数据处理
 */
@Service
public class ChatGroupService extends BaseService<ChatGroupEntity, ChatGroupRepository> {
    @Provider
    @Override
    public ChatGroupEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ChatGroupEntity> getAll() {
        return getList();
    }
}
