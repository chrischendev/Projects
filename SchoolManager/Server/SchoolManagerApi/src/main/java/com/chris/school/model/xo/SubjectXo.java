package com.chris.school.model.xo;

import lombok.Data;
import com.chris.school.model.orm.SubjectEntity;
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
@Expand(baseEntity = SubjectEntity.class)
public class SubjectXo {
    private Integer id;
    private String name;
    private String description;
}