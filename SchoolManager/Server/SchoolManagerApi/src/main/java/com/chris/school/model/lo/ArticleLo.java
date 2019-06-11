package com.chris.school.model.lo;

import com.chris.framework.builder.annotation.ExpandField;
import com.chris.school.model.orm.ArticleEntity;
import lombok.Data;
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
@Expand(baseEntity = ArticleEntity.class)
public class ArticleLo {
    private Integer id;
    private String title;
    @ExpandField(baseField="authorId")
    private UserInfoEntity author;
    private String authorName;
    private Long publishTime;
    private String content;
    private String link;
}