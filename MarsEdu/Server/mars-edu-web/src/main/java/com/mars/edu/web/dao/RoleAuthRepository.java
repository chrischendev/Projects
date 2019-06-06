package com.mars.edu.web.dao;

import com.mars.edu.web.model.orm.SysRoleAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:25
 * Use for:
 */
public interface RoleAuthRepository extends JpaRepository<SysRoleAuthEntity, Long> {
    /**
     * 根据角色id查询权限集合
     * @param roleId
     * @return
     */
    List<SysRoleAuthEntity> findAllByRoleId(long roleId);
}
