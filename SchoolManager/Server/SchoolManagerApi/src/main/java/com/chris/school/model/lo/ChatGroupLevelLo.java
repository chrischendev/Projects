package com.chris.school.model.lo;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.chris.framework.builder.annotation.Expand;
import com.chris.school.model.orm.ChatGroupLevelEntity;
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
@Expand(baseEntity = ChatGroupLevelEntity.class)
public class ChatGroupLevelLo {
    private Integer id;
    private Integer levelNo;
    private String name;
    private Integer capacity;
    private String description;
}