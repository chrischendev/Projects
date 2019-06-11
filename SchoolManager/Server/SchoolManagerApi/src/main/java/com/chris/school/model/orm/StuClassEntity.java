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
@Entity(name = "tb_stu_class")
public class StuClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "grade_id", nullable = true)
    private Integer gradeId;

    @Basic
    @Column(name = "headmaster_id", nullable = true)
    private Integer headmasterId;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

}