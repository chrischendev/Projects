package com.chris.ccnovel.news.api;

import com.chris.ccnovel.news.model.NewsEntity;
import com.chris.ccnovel.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/8/17 11:39
 * use for:
 */
@RestController
@RequestMapping("/news")
public class NewsApi {
    @Autowired
    NewsService newsService;

    @GetMapping("/search")
    public List<NewsEntity> search(String newsType, int page, int pageSize) {
        return newsService.searchPage(newsType, page, pageSize);
    }
}
