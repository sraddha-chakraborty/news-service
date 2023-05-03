package com.project.newsservice.application.news;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.newsservice.domain.News;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewsService {
    private final ThirdPartyNewsService thirdPartyNewsService;

    public List<News> getAllNews(String fetchDate){
        //Return news by fetching from Google News API
        return thirdPartyNewsService.getAllNews(fetchDate);
    }
}
