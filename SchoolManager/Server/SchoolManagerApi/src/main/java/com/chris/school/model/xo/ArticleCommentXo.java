package com.chris.school.model.xo;

import com.chris.framework.builder.annotation.ExpandField;
import com.chris.school.model.orm.ArticleEntity;
import lombok.Data;
import com.chris.school.model.orm.ArticleCommentEntity;
import com.chris.school.model.orm.UserInfoEntity;
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
@Expand(baseEntity = ArticleCommentEntity.class)
public class ArticleCommentXo {
    private Integer id;
    @ExpandField(baseField="userId")
    private UserInfoXo user;
    private String userName;
    private String contact;
    @ExpandField(baseField="articleId")
    private ArticleXo article;
    private String content;
    private Long time;
    @ExpandField(baseField="commentId")
    private ArticleCommentXo comment;
    private Integer sort;
}