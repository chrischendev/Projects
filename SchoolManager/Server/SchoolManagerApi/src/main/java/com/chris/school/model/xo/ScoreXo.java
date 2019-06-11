package com.chris.school.model.xo;

import com.chris.framework.builder.annotation.ExpandField;
import lombok.Data;
import com.chris.school.model.orm.StudentEntity;
import com.chris.school.model.orm.ScoreEntity;
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
@Expand(baseEntity = ScoreEntity.class)
public class ScoreXo {
    private Integer id;
    @ExpandField(baseField="studentId")
    private StudentXo student;
    @ExpandField(baseField="subjectId")
    private SubjectXo subject;
    private Integer score;
}