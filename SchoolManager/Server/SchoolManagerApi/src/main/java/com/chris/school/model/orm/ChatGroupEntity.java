package com.chris.school.model.orm;

import java.sql.Timestamp;
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
@Entity(name = "tb_chat_group")
public class ChatGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "group_no", nullable = false)
    private Integer groupNo;

    @Basic
    @Column(name = "name", nullable = true)
    private String name;

    @Basic
    @Column(name = "owner_id", nullable = true)
    private Integer ownerId;

    @Basic
    @Column(name = "type_id", nullable = true)
    private Integer typeId;

    @Basic
    @Column(name = "level_id", nullable = true)
    private Integer levelId;

    @Basic
    @Column(name = "time", nullable = true)
    private Timestamp time;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

}