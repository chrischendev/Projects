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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
