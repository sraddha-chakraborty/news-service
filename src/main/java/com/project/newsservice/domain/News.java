package com.project.newsservice.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class News {
    private String heading;
    private String content;
    private String source;
    private String publishDate;
    private String author;
}
