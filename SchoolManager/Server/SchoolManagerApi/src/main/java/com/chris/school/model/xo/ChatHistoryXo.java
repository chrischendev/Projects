package com.chris.school.model.xo;

import com.chris.framework.builder.annotation.ExpandField;
import lombok.Data;
import com.chris.school.model.orm.ChatGroupEntity;
import com.chris.school.model.orm.ChatHistoryEntity;
import com.chris.school.model.orm.UserInfoEntity;
import lombok.AllArgsConstructor;
import com.chris.framework.builder.annotation.Expand;
import lombok.NoArgsConstructor;

/**
 * App: ChrisApplication
 * Pkg: com.chris.school.model.xo
 * Author: Chris Chen
 * Time: 2018/07/03
 * Explain: 
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Expand(baseEntity = ChatHistoryEntity.class)
public class ChatHistoryXo {
    private Integer id;
    @ExpandField(baseField="fromId")
    private UserInfoXo from;
    @ExpandField(baseField="toId")
    private UserInfoXo to;
    @ExpandField(baseField="toGroupId")
    private ChatGroupXo toGroup;
    private Integer type;
    private String content;
}