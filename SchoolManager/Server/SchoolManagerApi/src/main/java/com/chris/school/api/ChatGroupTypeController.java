package com.chris.school.api;

import com.chris.school.biz.ChatGroupTypeService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ChatGroupTypeEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 聊天室类型 接口
 */
@Api(value = "聊天室类型", tags = "01. ChatGroupType", description = "聊天室类型")
@RestController
@RequestMapping("/chatGroupType")
public class ChatGroupTypeController extends BaseAppController<ChatGroupTypeEntity, ChatGroupTypeService> {
    @Autowired
    ChatGroupTypeService service;

    @Override
    public ChatGroupTypeService service() {
        return service;
    }

}
