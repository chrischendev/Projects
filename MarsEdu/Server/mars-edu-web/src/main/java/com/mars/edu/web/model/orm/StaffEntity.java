package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:13
 * Use for:
 */
@Entity
@Table(name = "sch_staff", schema = "db_mars_edu", catalog = "")
public class StaffEntity {
    private int id;
    private int schoolId;
    private String firstName;
    private String lastName;
    private Integer level;
    private String identityCardCode;
    private String cell;
    private String email;
    private String qqCode;
    private String wechatCode;
    private String siteUrl;
    private int status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "school_id", nullable = false)
    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 4)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 10)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "level", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "identity_card_code", nullable = true, length = 18)
    public String getIdentityCardCode() {
        return identityCardCode;
    }

    public void setIdentityCardCode(String identityCardCode) {
        this.identityCardCode = identityCardCode;
    }

    @Basic
    @Column(name = "cell", nullable = true, length = 11)
    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "qq_code", nullable = false, length = 13)
    public String getQqCode() {
        return qqCode;
    }

    public void setQqCode(String qqCode) {
        this.qqCode = qqCode;
    }

    @Basic
    @Column(name = "wechat_code", nullable = false, length = 32)
    public String getWechatCode() {
        return wechatCode;
    }

    public void setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode;
    }

    @Basic
    @Column(name = "site_url", nullable = true, length = 128)
    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return id == that.id &&
                schoolId == that.schoolId &&
                status == that.status &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(level, that.level) &&
                Objects.equals(identityCardCode, that.identityCardCode) &&
                Objects.equals(cell, that.cell) &&
                Objects.equals(email, that.email) &&
                Objects.equals(qqCode, that.qqCode) &&
                Objects.equals(wechatCode, that.wechatCode) &&
                Objects.equals(siteUrl, that.siteUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolId, firstName, lastName, level, identityCardCode, cell, email, qqCode, wechatCode, siteUrl, status);
    }
}
