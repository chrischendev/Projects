package com.chris.school.dao;

import com.chris.framework.builder.libs.springboot.repository.BaseRepository;
import com.chris.school.model.orm.ChatHistoryEntity;

/**
 * SchoolManagerApi
 * com.chris.school.dao
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 聊天记录 数据访问
 */
public interface ChatHistoryRepository extends BaseRepository<ChatHistoryEntity> {
}
