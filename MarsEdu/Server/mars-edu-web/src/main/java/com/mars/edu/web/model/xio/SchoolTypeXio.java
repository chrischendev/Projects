package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:15
 * Use for:
 */
@XlsSheet("school_type")
public class SchoolTypeXio {
    @XlsColumn("编码")
    private byte code;
    @XlsColumn("名称")
    private String name;
    @XlsColumn("级别")
    private byte level;
    @XlsColumn("描述")
    private String description;

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
