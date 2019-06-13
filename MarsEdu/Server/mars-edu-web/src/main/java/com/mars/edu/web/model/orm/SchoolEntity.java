package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 13:55
 * Use for:
 */
@Entity
@Table(name = "sys_school", schema = "db_mars_edu", catalog = "")
public class SchoolEntity {
    private int id;
    private String code;
    private String name;
    private int schoolType;
    private String email;
    private String address;
    private Timestamp regTime;
    private Timestamp activeTime;
    private Timestamp invalidTime;
    private String description;
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
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "school_type", nullable = false)
    public int getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(int schoolType) {
        this.schoolType = schoolType;
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
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "reg_time", nullable = true)
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Basic
    @Column(name = "active_time", nullable = true)
    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }

    @Basic
    @Column(name = "invalid_time", nullable = true)
    public Timestamp getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Timestamp invalidTime) {
        this.invalidTime = invalidTime;
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
        SchoolEntity that = (SchoolEntity) o;
        return id == that.id &&
                schoolType == that.schoolType &&
                status == that.status &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address) &&
                Objects.equals(regTime, that.regTime) &&
                Objects.equals(activeTime, that.activeTime) &&
                Objects.equals(invalidTime, that.invalidTime) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, schoolType, email, address, regTime, activeTime, invalidTime, description, status);
    }
}
