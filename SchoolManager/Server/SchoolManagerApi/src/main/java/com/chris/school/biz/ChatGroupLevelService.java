package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ChatGroupLevelRepository;
import com.chris.school.model.orm.ChatGroupLevelEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 聊天室级别 数据处理
 */
@Service
public class ChatGroupLevelService extends BaseService<ChatGroupLevelEntity, ChatGroupLevelRepository> {
    @Provider
    @Override
    public ChatGroupLevelEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ChatGroupLevelEntity> getAll() {
        return getList();
    }
}
