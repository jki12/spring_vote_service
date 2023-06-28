package com.example.vote.dto;

import com.example.vote.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostDto {
    private User user; // cookie.
    private String title;
    private String description;

    public PostDto(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }
}
