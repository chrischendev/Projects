package com.chris.school.model.xo;

import com.chris.framework.builder.annotation.ExpandField;
import com.chris.school.model.orm.StuClassEntity;
import lombok.Data;
import com.chris.school.model.orm.GradeEntity;
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
@Expand(baseEntity = StuClassEntity.class)
public class StuClassXo {
    private Integer id;
    private String name;
    @ExpandField(baseField="gradeId")
    private GradeXo grade;
    @ExpandField(baseField="headmasterId")
    private TeacherXo headmaster;
    private String description;
}