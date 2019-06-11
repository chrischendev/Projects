package com.chris.school.model.lo;

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
 * Pkg: com.chris.school.model.lo
 * Author: Chris Chen
 * Time: 2018/07/03
 * Explain: 
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Expand(baseEntity = ArticleCommentEntity.class)
public class ArticleCommentLo {
    private Integer id;
    @ExpandField(baseField="userId")
    private UserInfoEntity user;
    private String userName;
    private String contact;
    @ExpandField(baseField="articleId")
    private ArticleEntity article;
    private String content;
    private Long time;
    @ExpandField(baseField="commentId")
    private ArticleCommentEntity comment;
    private Integer sort;
}