package com.mars.edu.web.dao;

import com.mars.edu.web.locallibs.mars.MarsRepository;
import com.mars.edu.web.model.orm.SysRoleAuthEntity;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:25
 * Use for:
 */
public interface RoleAuthRepository extends MarsRepository<SysRoleAuthEntity> {
    /**
     * 根据角色id查询权限集合
     *
     * @param roleId
     * @return
     */
    List<SysRoleAuthEntity> findAllByRoleId(long roleId);
}
