package com.mars.edu.web.locallibs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:26
 * Use for: 整合JpaRepository<T, ID>和Specification<T>
 */
@NoRepositoryBean
public interface MarsRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
