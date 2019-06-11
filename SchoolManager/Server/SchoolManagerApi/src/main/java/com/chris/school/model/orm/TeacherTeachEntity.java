package com.chris.school.model.orm;

import lombok.Data;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * App: ChrisApplication
 * Pkg: com.chris.school.model.orm
 * Author: Chris Chen
 * Time: 2018/07/03
 * Explain: 
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "tb_teacher_teach")
public class TeacherTeachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "stu_class_id", nullable = true)
    private Integer stuClassId;

    @Basic
    @Column(name = "subject_id", nullable = true)
    private Integer subjectId;

    @Basic
    @Column(name = "teacher_id", nullable = true)
    private Integer teacherId;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

}