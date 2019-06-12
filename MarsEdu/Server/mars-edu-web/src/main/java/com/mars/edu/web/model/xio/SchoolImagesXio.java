package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:14
 * Use for:
 */
@XlsSheet("school_images")
public class SchoolImagesXio {
    @XlsColumn("学校ID")
    private int schoolId;
    @XlsColumn("图片URL")
    private String url;
    @XlsColumn("图片类型ID")
    private Integer type;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
