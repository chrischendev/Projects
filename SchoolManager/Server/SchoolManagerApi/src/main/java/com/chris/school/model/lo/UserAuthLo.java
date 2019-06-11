package com.chris.school.model.lo;

import com.chris.framework.builder.annotation.ExpandField;
import com.chris.school.model.orm.UserRoleEntity;
import lombok.Data;
import com.chris.school.model.orm.UserInfoEntity;
import lombok.AllArgsConstructor;
import com.chris.school.model.orm.UserAuthEntity;
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
@Expand(baseEntity = UserAuthEntity.class)
public class UserAuthLo {
    private Integer id;
    private String userName;
    private String cell;
    private String password;
    @ExpandField(baseField="userId")
    private UserInfoEntity user;
    @ExpandField(baseField="roleId")
    private UserRoleEntity role;
    private Long regTime;
    private String description;
}