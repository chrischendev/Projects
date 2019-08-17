package com.chris.ccnovel.news.dao;

import com.chris.ccnovel.news.model.NewsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/8/17 11:39
 * use for:
 */
public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {
    List<NewsEntity> findAllByType(String newsType, Pageable pageable);
}
