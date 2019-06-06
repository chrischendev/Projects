package com.mars.edu.web.locallibs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:26
 * Use for: 整合JpaRepository<T, ID>和Specification<T>
 */
public interface MarsRepository<T, ID> extends JpaRepository<T, ID>, Specification<T> {
}
