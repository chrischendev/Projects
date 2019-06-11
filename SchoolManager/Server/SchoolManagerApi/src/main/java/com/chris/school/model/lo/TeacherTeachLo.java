package com.chris.school.model.lo;

import com.chris.framework.builder.annotation.ExpandField;
import com.chris.school.model.orm.TeacherTeachEntity;
import lombok.Data;
import com.chris.school.model.orm.StuClassEntity;
import com.chris.school.model.orm.TeacherEntity;
import com.chris.school.model.orm.SubjectEntity;
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
@Expand(baseEntity = TeacherTeachEntity.class)
public class TeacherTeachLo {
    private Integer id;
    @ExpandField(baseField="stuClassId")
    private StuClassEntity stuClass;
    @ExpandField(baseField="subjectId")
    private SubjectEntity subject;
    @ExpandField(baseField="teacherId")
    private TeacherEntity teacher;
    private String description;
}