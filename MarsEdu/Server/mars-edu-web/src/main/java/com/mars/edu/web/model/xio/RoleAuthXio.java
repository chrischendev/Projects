package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:20
 * Use for:
 */
@XlsSheet("sys_role_auth")
public class RoleAuthXio {
    @XlsColumn("角色ID")
    private int roleId;
    @XlsColumn("权限ID")
    private int authId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }
}
