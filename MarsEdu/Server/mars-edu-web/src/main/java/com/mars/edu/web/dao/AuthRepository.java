package com.mars.edu.web.dao;

import com.mars.edu.web.locallibs.MarsRepository;
import com.mars.edu.web.model.orm.SysAuthEntity;
import com.mars.edu.web.model.orm.SysRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:25
 * Use for:
 */
public interface AuthRepository extends MarsRepository<SysAuthEntity, Long> {
}
