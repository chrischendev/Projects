package com.chris.school.model.lo;

import com.chris.framework.builder.annotation.ExpandField;
import com.chris.school.model.orm.ChatGroupTypeEntity;
import com.chris.school.model.orm.ChatGroupEntity;
import lombok.Data;
import com.chris.school.model.orm.UserInfoEntity;
import lombok.AllArgsConstructor;
import com.chris.framework.builder.annotation.Expand;
import lombok.NoArgsConstructor;
import com.chris.school.model.orm.ChatGroupLevelEntity;

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
@Expand(baseEntity = ChatGroupEntity.class)
public class ChatGroupLo {
    private Integer id;
    private Integer groupNo;
    private String name;
    @ExpandField(baseField="ownerId")
    private UserInfoEntity owner;
    @ExpandField(baseField="typeId")
    private ChatGroupTypeEntity type;
    @ExpandField(baseField="levelId")
    private ChatGroupLevelEntity level;
    private Long time;
    private String description;
}