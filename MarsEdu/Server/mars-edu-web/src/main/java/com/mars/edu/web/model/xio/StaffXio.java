package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:15
 * Use for:
 */
@XlsSheet("staff")
public class StaffXio {
    @XlsColumn("学校ID")
    private int schoolId;
    @XlsColumn("姓")
    private String firstName;
    @XlsColumn("名")
    private String lastName;
    @XlsColumn("级别")
    private Byte level;
    @XlsColumn("身份证号码")
    private String identityCardCode;
    @XlsColumn("手机")
    private String cell;
    @XlsColumn("邮箱")
    private String email;
    @XlsColumn("QQ")
    private String qqCode;
    @XlsColumn("微信")
    private String wechatCode;
    @XlsColumn("个人主页")
    private String siteUrl;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getIdentityCardCode() {
        return identityCardCode;
    }

    public void setIdentityCardCode(String identityCardCode) {
        this.identityCardCode = identityCardCode;
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

    public String getQqCode() {
        return qqCode;
    }

    public void setQqCode(String qqCode) {
        this.qqCode = qqCode;
    }

    public String getWechatCode() {
        return wechatCode;
    }

    public void setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
