package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:20
 * Use for:
 */
@Entity
@Table(name = "sys_user_role", schema = "db_mars_edu", catalog = "")
public class UserRoleEntity {
    private int id;
    private int userId;
    private int roleId;
    private int status;

    public UserRoleEntity() {
    }

    public UserRoleEntity(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRoleEntity(int id, int userId, int roleId, int status) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
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
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        UserRoleEntity that = (UserRoleEntity) o;
        return id == that.id &&
                userId == that.userId &&
                roleId == that.roleId &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId, status);
    }
}
