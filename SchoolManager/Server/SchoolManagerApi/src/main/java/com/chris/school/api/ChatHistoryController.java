package com.chris.school.api;

import com.chris.school.biz.ChatHistoryService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ChatHistoryEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 聊天记录 接口
 */
@Api(value = "聊天记录", tags = "01. ChatHistory", description = "聊天记录")
@RestController
@RequestMapping("/chatHistory")
public class ChatHistoryController extends BaseAppController<ChatHistoryEntity, ChatHistoryService> {
    @Autowired
    ChatHistoryService service;

    @Override
    public ChatHistoryService service() {
        return service;
    }

}
