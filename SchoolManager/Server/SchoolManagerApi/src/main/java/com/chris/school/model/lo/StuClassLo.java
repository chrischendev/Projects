package com.chris.school.model.lo;

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
 * Pkg: com.chris.school.model.lo
 * Author: Chris Chen
 * Time: 2018/07/03
 * Explain: 
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Expand(baseEntity = StuClassEntity.class)
public class StuClassLo {
    private Integer id;
    private String name;
    @ExpandField(baseField="gradeId")
    private GradeEntity grade;
    @ExpandField(baseField="headmasterId")
    private TeacherEntity headmaster;
    private String description;
}