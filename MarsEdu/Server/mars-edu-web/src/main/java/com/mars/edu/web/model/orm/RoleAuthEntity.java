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
public class RoleAuthEntity {
    private int id;
    private int roleId;
    private int authId;
    private int status;

    public RoleAuthEntity() {
    }

    public RoleAuthEntity(int roleId, int authId) {
        this.roleId = roleId;
        this.authId = authId;
    }

    public RoleAuthEntity(int id, int roleId, int authId, int status) {
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
        RoleAuthEntity that = (RoleAuthEntity) o;
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
