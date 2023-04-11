package com.project.newsservice.infra.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.newsservice.application.news.ThirdPartyNewsService;
import com.project.newsservice.domain.News;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "get-all-news", url = "https://newsapi.org/v2")
public interface GoogleNewsServiceUsingFeignClient {
    @GetMapping("/everything?q=apple&from=2023-04-07&to=2023-04-07&sortBy=popularity&apiKey=c0c15cf3cbb741268a2955c21424235b")
    Object getAllNews();
    @GetMapping("/everything?domains=wsj.com&apiKey=c0c15cf3cbb741268a2955c21424235b")
    Object getAllWsjNews();
}
