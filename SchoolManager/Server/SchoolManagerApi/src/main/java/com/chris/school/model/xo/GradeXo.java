package com.chris.school.model.xo;

import com.chris.framework.builder.annotation.ExpandField;
import com.chris.school.model.orm.GradeEntity;
import lombok.Data;
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
@Expand(baseEntity = GradeEntity.class)
public class GradeXo {
    private Integer id;
    private String name;
    @ExpandField(baseField="schoolId")
    private SchoolXo school;
    private String description;
}