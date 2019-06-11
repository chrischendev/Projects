package com.chris.school.model.lo;

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
@Expand(baseEntity = UserInfoEntity.class)
public class UserInfoLo {
    private Integer id;
    private String lastName;
    private String firstName;
    private String nickName;
    private Boolean gender;
    private String address;
    private String email;
    private String qqNumber;
    private String wechatNumber;
    private String description;
}