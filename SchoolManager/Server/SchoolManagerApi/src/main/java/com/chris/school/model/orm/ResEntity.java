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
@Entity(name = "tb_res")
public class ResEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "res_no", nullable = false)
    private Integer resNo;

    @Basic
    @Column(name = "links", nullable = true)
    private String links;

    @Basic
    @Column(name = "res_type_id", nullable = false)
    private Integer resTypeId;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

}