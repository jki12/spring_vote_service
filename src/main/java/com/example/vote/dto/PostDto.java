package com.example.vote.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostDto {
    private String title;
    private String description;

    public PostDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
