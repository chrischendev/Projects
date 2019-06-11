package com.chris.school.api;

import com.chris.school.biz.ChatGroupMemberService;
import com.chris.school.libs.BaseAppController;
import com.chris.school.model.orm.ChatGroupMemberEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SchoolManagerApi
 * com.chris.school
 * Created by Chris Chen
 * 2018/6/3
 * Explain: 聊天群成员 接口
 */
@Api(value = "聊天群成员", tags = "01. ChatGroupMember", description = "聊天群成员")
@RestController
@RequestMapping("/chatGroupMember")
public class ChatGroupMemberController extends BaseAppController<ChatGroupMemberEntity, ChatGroupMemberService> {
    @Autowired
    ChatGroupMemberService service;

    @Override
    public ChatGroupMemberService service() {
        return service;
    }

}
