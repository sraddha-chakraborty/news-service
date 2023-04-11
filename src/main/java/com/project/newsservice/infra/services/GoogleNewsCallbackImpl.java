package com.project.newsservice.infra.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.newsservice.domain.News;

@Component
public class GoogleNewsCallbackImpl implements GoogleNewsCallback{

    List<News> sendResult = new ArrayList<>();
    @Override
    public void setResult(List<News> result) {
        sendResult.clear();
        sendResult.addAll(result);
    }

    @Override
    public List<News> getResult() {
       return sendResult;
    }
    
}
