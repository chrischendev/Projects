package com.mars.edu.web.locallibs.mars;

import com.mars.edu.web.locallibs.base.BaseRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * create by: Chris Chan
 * create on: 2019/6/9 23:16
 * use for:
 */
@NoRepositoryBean
public interface MarsBaseRepository<T> extends BaseRepository<T, Integer> {
}
