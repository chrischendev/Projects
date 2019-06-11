package com.chris.school.model.xo;

import com.chris.school.model.orm.ChatGroupTypeEntity;
import lombok.Data;
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
@Expand(baseEntity = ChatGroupTypeEntity.class)
public class ChatGroupTypeXo {
    private Integer id;
    private Integer typeNo;
    private String name;
    private String description;
}