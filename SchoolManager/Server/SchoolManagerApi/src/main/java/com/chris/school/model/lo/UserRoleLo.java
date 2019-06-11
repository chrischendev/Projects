package com.chris.school.model.lo;

import com.chris.school.model.orm.UserRoleEntity;
import lombok.Data;
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
@Expand(baseEntity = UserRoleEntity.class)
public class UserRoleLo {
    private Integer id;
    private Integer roleNo;
    private String name;
    private String description;
}