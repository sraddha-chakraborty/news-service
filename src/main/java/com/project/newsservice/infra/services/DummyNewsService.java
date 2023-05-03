package com.project.newsservice.infra.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.newsservice.domain.News;

@Component
public class DummyNewsService {//implements ThirdPartyNewsService{
    public List<News> getAllNews(){
        return Arrays.asList(
            News.builder()
            .heading("Earthquake in Delhi")
            .author("Attyuttam Saha")
            .content("There was a huge earthquake in Delhi today at 9AM")
            .publishDate(new Date().toString())
            .source("NDTV")
            .build(),
            News.builder()
            .heading("100 startups get unicorn status")
            .author("Sraddha Chakraborty")
            .content("100 startups from India has gotten unicorn status")
            .publishDate(new Date().toString())
            .source("TOI")
            .build(),
            News.builder()
            .heading("Starbucks is now offering free Coffee !")
            .author("Puskar Karmakar")
            .content("Starbucks has decided to offer free coffee to all students from today")
            .publishDate(new Date().toString())
            .source("Reddit")
            .build()
        );
    }
}
