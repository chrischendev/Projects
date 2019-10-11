package com.chris.sl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/10/2 11:31
 * use for: 登录用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    private String username;
    private String password;
}
