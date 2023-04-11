package com.project.newsservice.infra.services;

import java.util.List;

import com.project.newsservice.domain.News;

public interface GoogleNewsCallback {
    public void setResult(List<News> result);
    public List<News> getResult();
}
