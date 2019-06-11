package com.chris.school.api;

import com.chris.school.biz.ChatGroupLevelService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ChatGroupLevelEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 聊天室级别 接口
 */
@Api(value = "聊天室级别", tags = "01. ChatGroupLevel", description = "聊天室级别")
@RestController
@RequestMapping("/chatGroupLevel")
public class ChatGroupLevelController extends BaseAppController<ChatGroupLevelEntity, ChatGroupLevelService> {
    @Autowired
    ChatGroupLevelService service;

    @Override
    public ChatGroupLevelService service() {
        return service;
    }

}
