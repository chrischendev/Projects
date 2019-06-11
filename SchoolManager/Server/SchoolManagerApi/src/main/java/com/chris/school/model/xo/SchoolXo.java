package com.chris.school.model.xo;

import com.chris.framework.builder.annotation.ExpandField;
import lombok.Data;
import com.chris.school.model.orm.TeacherEntity;
import com.chris.school.model.orm.SchoolEntity;
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
@Expand(baseEntity = SchoolEntity.class)
public class SchoolXo {
    private Integer id;
    private String name;
    private String address;
    @ExpandField(baseField="headmasterId")
    private TeacherXo headmaster;
    private String description;
}