package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:20
 * Use for:
 */
@XlsSheet("sys_user_role")
public class UserRoleXio {
    @XlsColumn("用户ID")
    private int userId;
    @XlsColumn("角色ID")
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
