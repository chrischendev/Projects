package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:20
 * Use for:
 */
@Entity
@Table(name = "sys_role_auth", schema = "db_mars_edu", catalog = "")
public class SysRoleAuthEntity {
    private int id;
    private int roleId;
    private int authId;
    private byte status;

    public SysRoleAuthEntity() {
    }

    public SysRoleAuthEntity(int roleId, int authId) {
        this.roleId = roleId;
        this.authId = authId;
    }

    public SysRoleAuthEntity(int id, int roleId, int authId, byte status) {
        this.id = id;
        this.roleId = roleId;
        this.authId = authId;
        this.status = status;
    }

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
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "auth_id", nullable = false)
    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
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
        SysRoleAuthEntity that = (SysRoleAuthEntity) o;
        return id == that.id &&
                roleId == that.roleId &&
                authId == that.authId &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, authId, status);
    }
}
