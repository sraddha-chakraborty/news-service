package com.project.newsservice.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NewsServiceConfiguration {
    @Bean
	public RestTemplate getRestTemplate() {
    	return new RestTemplate();
   }
}
