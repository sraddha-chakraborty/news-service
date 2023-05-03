package com.project.newsservice.infra.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.project.newsservice.application.news.ThirdPartyNewsService;
import com.project.newsservice.domain.News;


@Component
public class GoogleNewsService implements ThirdPartyNewsService{
    public GoogleNewsCallback googleNewsCallback;

    //this is known as constructor injection
    public GoogleNewsService(GoogleNewsCallback googleNewsCallback){
        this.googleNewsCallback = googleNewsCallback;
    }

    @Override
    public List<News> getAllNews(String fetchDate) {
        NewsApiClient newsApiClient = new NewsApiClient("c0c15cf3cbb741268a2955c21424235b");
       
        newsApiClient.getEverything(
            new EverythingRequest.Builder()
               .q("trump")
               .language("en")
               .from(fetchDate)
               .to(fetchDate)
               .pageSize(20)
                .build(),
            new NewsApiClient.ArticlesResponseCallback() {
                @Override
                public void onSuccess(ArticleResponse response) {
                    //System.out.println(response.getArticles().get(0).getTitle());
                    List<News> res = new ArrayList<>();
                    for (int index=0; index < response.getArticles().size(); index++ )
                    {
                        res.add(News.builder()
                        .heading(response.getArticles().get(index).getTitle())
                        .author(response.getArticles().get(index).getAuthor())
                        .content(response.getArticles().get(index).getContent())
                        .publishDate(response.getArticles().get(index).getPublishedAt())
                        .source(response.getArticles().get(index).getSource().toString())
                        .build());
                    }
                    googleNewsCallback.setResult(res);
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println(throwable.getMessage());
                }
            }
        );              
        return googleNewsCallback.getResult();
    }
    
}
