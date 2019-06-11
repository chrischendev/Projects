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
@Entity(name = "tb_score")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Basic
    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

    @Basic
    @Column(name = "score", nullable = true)
    private Integer score;

}