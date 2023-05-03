package com.project.newsservice.infra.controller;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.newsservice.application.news.NewsService;
import com.project.newsservice.application.repository.NewsRepository;
import com.project.newsservice.domain.News;
import com.project.newsservice.domain.ThirdPartyNews;
import com.project.newsservice.infra.services.GoogleNewsServiceUsingFeignClient;
import org.json.JSONObject;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NewsServiceController {
    private final GoogleNewsServiceUsingFeignClient googleNewsServiceUsingFeignClient;
    private final RestTemplate restTemplate;
    private final NewsService newsService;

    private final ObjectMapper objectMapper;

    private final NewsRepository newsRepository; 

    @GetMapping("/get-all-news-rest-template")
    public Object getNewsRestTemplate() throws JsonProcessingException, RestClientException{
      
        return objectMapper.readValue(restTemplate.exchange("https://newsapi.org/v2/everything?q=apple&from=2023-04-07&to=2023-04-07&sortBy=popularity&apiKey=c0c15cf3cbb741268a2955c21424235b", HttpMethod.GET, null, String.class).getBody(), Object.class);
    }

    @GetMapping("/get-all-news-feign-client")
    public Object getNewsFeignClient() throws JsonProcessingException, RestClientException{

        return objectMapper.readValue(objectMapper.writeValueAsString(googleNewsServiceUsingFeignClient.getAllNews()), Object.class);
    }

    @GetMapping("/get-all-news")
    public List<News> getNews(@RequestParam String fetchDate) throws JsonProcessingException, RestClientException{

        return newsService.getAllNews(fetchDate);
    }

    @GetMapping("/save-news-to-h2-databse")
    public Object saveNewsToH2Database() throws JsonProcessingException, RestClientException
    {
        JSONObject newsJson = new JSONObject(objectMapper.writeValueAsString(googleNewsServiceUsingFeignClient.getAllNews()));
        ThirdPartyNews thirdPartyNews = ThirdPartyNews.builder()
        .status(newsJson.get("status").toString())
        .totalResults(newsJson.get("totalResults").toString())
        .articles("NULL")
        .build();
        
        newsRepository.save(thirdPartyNews);

        return thirdPartyNews;
    }
}