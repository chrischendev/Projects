package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:15
 * Use for:
 */
@XlsSheet("school_info")
public class SchoolInfoXio {
    @XlsColumn("学校ID")
    private int schoolId;
    @XlsColumn("一级区域代码")
    private String areaCode;
    @XlsColumn("一级区域名称")
    private String areaName;
    @XlsColumn("二级区域代码")
    private String secondAreaCode;
    @XlsColumn("二级区域名称")
    private String secondAreaName;
    @XlsColumn("三级区域代码")
    private String thirdAreaCode;
    @XlsColumn("三级区域名称")
    private String thirdAreaName;
    @XlsColumn("描述")
    private String description;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSecondAreaCode() {
        return secondAreaCode;
    }

    public void setSecondAreaCode(String secondAreaCode) {
        this.secondAreaCode = secondAreaCode;
    }

    public String getSecondAreaName() {
        return secondAreaName;
    }

    public void setSecondAreaName(String secondAreaName) {
        this.secondAreaName = secondAreaName;
    }

    public String getThirdAreaCode() {
        return thirdAreaCode;
    }

    public void setThirdAreaCode(String thirdAreaCode) {
        this.thirdAreaCode = thirdAreaCode;
    }

    public String getThirdAreaName() {
        return thirdAreaName;
    }

    public void setThirdAreaName(String thirdAreaName) {
        this.thirdAreaName = thirdAreaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
