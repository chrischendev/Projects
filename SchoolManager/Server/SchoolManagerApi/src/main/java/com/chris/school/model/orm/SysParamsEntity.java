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
@Entity(name = "tb_sys_params")
public class SysParamsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "value", nullable = true)
    private String value;

    @Basic
    @Column(name = "level", nullable = true)
    private Integer level;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

}