package com.chris.ccnovel.news.service;

import com.chris.ccnovel.news.dao.NewsRepository;
import com.chris.ccnovel.news.model.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/8/17 11:49
 * use for:
 */
@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    public List<NewsEntity> searchPage(String newsType, int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return newsRepository.findAllByType(newsType, pageRequest.next());

    }
}
