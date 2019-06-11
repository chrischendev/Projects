package com.chris.school.model.lo;

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
 * Pkg: com.chris.school.model.lo
 * Author: Chris Chen
 * Time: 2018/07/03
 * Explain: 
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Expand(baseEntity = ChatHistoryEntity.class)
public class ChatHistoryLo {
    private Integer id;
    @ExpandField(baseField="fromId")
    private UserInfoEntity from;
    @ExpandField(baseField="toId")
    private UserInfoEntity to;
    @ExpandField(baseField="toGroupId")
    private ChatGroupEntity toGroup;
    private Integer type;
    private String content;
}