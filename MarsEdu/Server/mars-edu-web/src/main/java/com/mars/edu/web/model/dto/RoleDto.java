package com.mars.edu.web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:20
 * Use for:
 */
@Entity(name = "sys_role")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class RoleDto {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private byte status;

    @ManyToMany
    @JoinTable(name = "sys_role_auth",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "auth_id", referencedColumnName = "id")}
    )
    private Set<AuthDto> auths = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Set<AuthDto> getAuths() {
        return auths;
    }

    public void setAuths(Set<AuthDto> auths) {
        this.auths = auths;
    }
}
