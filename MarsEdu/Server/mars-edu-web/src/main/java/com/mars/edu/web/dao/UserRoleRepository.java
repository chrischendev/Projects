package com.mars.edu.web.dao;

import com.mars.edu.web.locallibs.mars.MarsRepository;
import com.mars.edu.web.model.orm.SysUserRoleEntity;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:25
 * Use for:
 */
public interface UserRoleRepository extends MarsRepository<SysUserRoleEntity> {
    /**
     * 根据用户id查询角色
     *
     * @param userId
     * @return
     */
    List<SysUserRoleEntity> findAllByUserId(long userId);
}
