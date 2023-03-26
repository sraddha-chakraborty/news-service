package com.project.newsservice.infra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.newsservice.application.news.NewsService;
import com.project.newsservice.domain.News;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NewsServiceController {
    private final NewsService newsService;
    
    @GetMapping("/get-all-news")
    public List<News> getNews(){
        return newsService.getAllNews();
    }
}
