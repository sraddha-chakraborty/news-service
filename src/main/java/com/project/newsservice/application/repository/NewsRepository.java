package com.project.newsservice.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.newsservice.domain.ThirdPartyNews;

public interface NewsRepository extends CrudRepository<ThirdPartyNews, String> {
}
