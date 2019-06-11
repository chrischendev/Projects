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
@Entity(name = "tb_chat_group_member")
public class ChatGroupMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;

    @Basic
    @Column(name = "group_id", nullable = true)
    private Integer groupId;

    @Basic
    @Column(name = "nick_name", nullable = true)
    private String nickName;

    @Basic
    @Column(name = "level", nullable = true)
    private Integer level;

    @Basic
    @Column(name = "time", nullable = false)
    private Timestamp time;

}