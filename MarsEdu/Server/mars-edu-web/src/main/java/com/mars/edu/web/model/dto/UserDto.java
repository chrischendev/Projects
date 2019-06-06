package com.mars.edu.web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:13
 * Use for:
 */
@Entity(name = "sys_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "cell", nullable = false, length = 20)
    private String cell;
    @Column(name = "email", nullable = false, length = 128)
    private String email;
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Column(name = "school_id", nullable = false, length = 20)
    private String schoolId;
    @Column(name = "status", nullable = false)
    private byte status;
    @ManyToMany
    @JoinTable(name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<RoleDto> roles = new HashSet<>();
}
