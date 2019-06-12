package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:13
 * Use for:
 */
@XlsSheet("school_grade")
public class SchoolGradeXio {
    @XlsColumn("学校ID")
    private int schoolId;
    @XlsColumn("编码")
    private String code;
    @XlsColumn("名称")
    private String name;
    @XlsColumn("级别")
    private int level;
    @XlsColumn("管理员ID")
    private Integer managerId;
    @XlsColumn("年级组长ID")
    private Integer leaderId;
    @XlsColumn("描述")
    private String description;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
