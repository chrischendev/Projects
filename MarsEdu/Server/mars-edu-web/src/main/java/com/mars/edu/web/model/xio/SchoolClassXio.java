package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:12
 * Use for:
 */
@XlsSheet("school_class")
public class SchoolClassXio {
    @XlsColumn("年级ID")
    private int gradeId;
    @XlsColumn("编码")
    private String code;
    @XlsColumn("名称")
    private String name;
    @XlsColumn("级别")
    private byte level;
    @XlsColumn("班主任ID")
    private Integer managerId;
    @XlsColumn("描述")
    private String description;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

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

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
