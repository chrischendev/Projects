package com.mars.edu.web.dao;

import com.mars.edu.web.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 16:33
 * Use for:
 */
public interface UserDtoRepository extends JpaRepository<UserDto, Long> {
}
