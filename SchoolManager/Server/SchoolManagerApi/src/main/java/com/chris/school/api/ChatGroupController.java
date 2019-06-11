package com.chris.school.api;

import com.chris.school.biz.ChatGroupService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ChatGroupEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 聊天群 接口
 */
@Api(value = "聊天群", tags = "01. ChatGroup", description = "聊天群")
@RestController
@RequestMapping("/chatGroup")
public class ChatGroupController extends BaseAppController<ChatGroupEntity, ChatGroupService> {
    @Autowired
    ChatGroupService service;

    @Override
    public ChatGroupService service() {
        return service;
    }

}
