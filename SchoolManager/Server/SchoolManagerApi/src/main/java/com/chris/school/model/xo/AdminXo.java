package com.chris.school.model.xo;

import com.chris.school.model.orm.AdminEntity;
import lombok.Data;
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
@Expand(baseEntity = AdminEntity.class)
public class AdminXo {
    private Integer id;
    private String name;
    private String cell;
    private String password;
    private Integer role;
    private String description;
}