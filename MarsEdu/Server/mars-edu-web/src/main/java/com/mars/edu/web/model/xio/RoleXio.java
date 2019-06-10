package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 17:25
 * Use for:
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@XlsSheet(value = "role")
public class RoleXio {
    @XlsColumn("编码")
    private String code;
    @XlsColumn("名称")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
