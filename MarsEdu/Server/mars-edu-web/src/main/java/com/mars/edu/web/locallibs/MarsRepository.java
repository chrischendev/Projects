package com.mars.edu.web.locallibs;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * create by: Chris Chan
 * create on: 2019/6/9 23:16
 * use for:
 */
@NoRepositoryBean
public interface MarsRepository<T> extends BaseRepository<T, Integer> {
}
