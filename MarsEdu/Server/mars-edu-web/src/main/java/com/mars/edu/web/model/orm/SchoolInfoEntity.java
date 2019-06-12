package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:13
 * Use for:
 */
@Entity
@Table(name = "sys_school_info", schema = "db_mars_edu", catalog = "")
public class SchoolInfoEntity {
    private int id;
    private int schoolId;
    private String areaCode;
    private String areaName;
    private String secondAreaCode;
    private String secondAreaName;
    private String thirdAreaCode;
    private String thirdAreaName;
    private String description;
    private byte status;

    @Id
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
    @Column(name = "area_code", nullable = true, length = 6)
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Basic
    @Column(name = "area_name", nullable = true, length = 6)
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "second_area_code", nullable = true, length = 6)
    public String getSecondAreaCode() {
        return secondAreaCode;
    }

    public void setSecondAreaCode(String secondAreaCode) {
        this.secondAreaCode = secondAreaCode;
    }

    @Basic
    @Column(name = "second_area_name", nullable = true, length = 6)
    public String getSecondAreaName() {
        return secondAreaName;
    }

    public void setSecondAreaName(String secondAreaName) {
        this.secondAreaName = secondAreaName;
    }

    @Basic
    @Column(name = "third_area_code", nullable = true, length = 6)
    public String getThirdAreaCode() {
        return thirdAreaCode;
    }

    public void setThirdAreaCode(String thirdAreaCode) {
        this.thirdAreaCode = thirdAreaCode;
    }

    @Basic
    @Column(name = "third_area_name", nullable = true, length = 6)
    public String getThirdAreaName() {
        return thirdAreaName;
    }

    public void setThirdAreaName(String thirdAreaName) {
        this.thirdAreaName = thirdAreaName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolInfoEntity that = (SchoolInfoEntity) o;
        return id == that.id &&
                schoolId == that.schoolId &&
                status == that.status &&
                Objects.equals(areaCode, that.areaCode) &&
                Objects.equals(areaName, that.areaName) &&
                Objects.equals(secondAreaCode, that.secondAreaCode) &&
                Objects.equals(secondAreaName, that.secondAreaName) &&
                Objects.equals(thirdAreaCode, that.thirdAreaCode) &&
                Objects.equals(thirdAreaName, that.thirdAreaName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolId, areaCode, areaName, secondAreaCode, secondAreaName, thirdAreaCode, thirdAreaName, description, status);
    }
}
