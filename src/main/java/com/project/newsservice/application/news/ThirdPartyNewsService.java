package com.project.newsservice.application.news;

import java.util.List;

import com.project.newsservice.domain.News;

public interface ThirdPartyNewsService {
    public List<News> getAllNews(String fetchDate);
}
