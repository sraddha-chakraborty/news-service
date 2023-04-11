package com.project.newsservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Source {
    private String id;
    private String name;
}
