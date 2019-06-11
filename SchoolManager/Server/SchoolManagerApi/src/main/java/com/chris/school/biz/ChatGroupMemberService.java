package com.chris.school.biz;

import com.chris.framework.builder.annotation.Provider;
import com.chris.framework.builder.libs.springboot.service.BaseService;
import com.chris.school.dao.ChatGroupMemberRepository;
import com.chris.school.model.orm.ChatGroupMemberEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SchoolManagerApi
 * com.chris.school.biz
 * Created by Chris Chen
 * 2018/7/3
 * Explain: 聊天群成员 数据处理
 */
@Service
public class ChatGroupMemberService extends BaseService<ChatGroupMemberEntity, ChatGroupMemberRepository> {
    @Provider
    @Override
    public ChatGroupMemberEntity getEntity(Integer id) {
        return id == null ? null : getOne(id);
    }

    @Provider
    @Override
    public List<ChatGroupMemberEntity> getAll() {
        return getList();
    }
}
