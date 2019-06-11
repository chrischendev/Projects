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
@Entity(name = "tb_article_comment")
public class ArticleCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;

    @Basic
    @Column(name = "user_name", nullable = true)
    private String userName;

    @Basic
    @Column(name = "contact", nullable = true)
    private String contact;

    @Basic
    @Column(name = "article_id", nullable = true)
    private Integer articleId;

    @Basic
    @Column(name = "content", nullable = true)
    private String content;

    @Basic
    @Column(name = "time", nullable = true)
    private Timestamp time;

    @Basic
    @Column(name = "comment_id", nullable = true)
    private Integer commentId;

    @Basic
    @Column(name = "sort", nullable = true)
    private Integer sort;

}