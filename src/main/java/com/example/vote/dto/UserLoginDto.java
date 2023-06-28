package com.example.vote.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginDto {
    private String email;
    private String pw;

    public UserLoginDto(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }
}
