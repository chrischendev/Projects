package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:13
 * Use for:
 */
@Entity
@Table(name = "sys_images_type", schema = "db_mars_edu", catalog = "")
public class ImagesTypeEntity {
    private int id;
    private byte code;
    private String name;
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
    @Column(name = "code", nullable = false)
    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        ImagesTypeEntity that = (ImagesTypeEntity) o;
        return id == that.id &&
                code == that.code &&
                status == that.status &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, status);
    }
}
