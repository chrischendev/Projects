package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:13
 * Use for:
 */
@Entity
@Table(name = "sys_school_images", schema = "db_mars_edu", catalog = "")
public class SchoolImagesEntity {
    private int id;
    private int schoolId;
    private String url;
    private Integer type;
    private byte status;

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
    @Column(name = "url", nullable = false, length = 512)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        SchoolImagesEntity that = (SchoolImagesEntity) o;
        return id == that.id &&
                schoolId == that.schoolId &&
                status == that.status &&
                Objects.equals(url, that.url) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolId, url, type, status);
    }
}
