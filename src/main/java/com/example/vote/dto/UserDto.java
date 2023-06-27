package com.example.vote.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
    private String email;
    private String pw;
    private String name;

    public UserDto(String email, String pw, String name) {
        this.email = email;
        this.pw = pw;
        this.name = name;
    }
}
