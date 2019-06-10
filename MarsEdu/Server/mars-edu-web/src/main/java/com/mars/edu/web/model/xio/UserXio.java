package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:13
 * Use for:
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@XlsSheet(value = "user")
public class UserXio {
    @XlsColumn("姓名")
    private String name;
    @XlsColumn("手机")
    private String cell;
    @XlsColumn("邮箱")
    private String email;
    @XlsColumn("密码")
    private String password;
    @XlsColumn("学校ID")
    private String schoolId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
