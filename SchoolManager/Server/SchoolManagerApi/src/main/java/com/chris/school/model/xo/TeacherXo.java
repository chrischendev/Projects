package com.chris.school.model.xo;

import com.chris.framework.builder.annotation.ExpandField;
import lombok.Data;
import com.chris.school.model.orm.TeacherEntity;
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
@Expand(baseEntity = TeacherEntity.class)
public class TeacherXo {
    private Integer id;
    private String name;
    private String cell;
    private Boolean gender;
    @ExpandField(baseField="userId")
    private TeacherXo user;
    private String description;
}