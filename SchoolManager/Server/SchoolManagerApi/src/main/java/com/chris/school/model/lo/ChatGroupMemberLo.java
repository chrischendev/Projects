package com.chris.school.model.lo;

import com.chris.framework.builder.annotation.ExpandField;
import lombok.Data;
import com.chris.school.model.orm.ChatGroupEntity;
import com.chris.school.model.orm.UserInfoEntity;
import lombok.AllArgsConstructor;
import com.chris.school.model.orm.ChatGroupMemberEntity;
import com.chris.framework.builder.annotation.Expand;
import lombok.NoArgsConstructor;

/**
 * App: ChrisApplication
 * Pkg: com.chris.school.model.lo
 * Author: Chris Chen
 * Time: 2018/07/03
 * Explain: 
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Expand(baseEntity = ChatGroupMemberEntity.class)
public class ChatGroupMemberLo {
    private Integer id;
    @ExpandField(baseField="userId")
    private UserInfoEntity user;
    @ExpandField(baseField="groupId")
    private ChatGroupEntity group;
    private String nickName;
    private Integer level;
    private Long time;
}