package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ChatHistoryRepository;
import com.chris.school.model.orm.ChatHistoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 聊天记录 数据处理
 */
@Service
public class ChatHistoryService extends BaseService<ChatHistoryEntity, ChatHistoryRepository> {
    @Provider
    @Override
    public ChatHistoryEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ChatHistoryEntity> getAll() {
        return getList();
    }
}
