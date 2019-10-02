package com.chris.sl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/10/2 11:34
 * use for: 登录信息
 * 包括登录用户名和识别码过期时间
 */
@Data@NoArgsConstructor@AllArgsConstructor
public class LoginInfo {
    private String username;
    private long expire;
    //是否已被占用
    private boolean occ;
}
