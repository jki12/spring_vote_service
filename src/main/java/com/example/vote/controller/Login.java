package com.example.vote.controller;

import com.example.vote.dto.UserLoginDto;
import com.example.vote.user.MemoryUserRepo;
import com.example.vote.user.User;
import com.example.vote.user.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Login {
    private final UserRepo repo = new MemoryUserRepo(); // to UserService.

    private Cookie generateCookie(User user) {
        return new Cookie("id", user.getId().toString());
    }

    @PostMapping("users/login")
    public boolean login(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response) {
        User user = repo.findByEmail(userLoginDto.getEmail());

        if (user == null || !user.getPw().equals(userLoginDto.getPw())) return false;

        response.addCookie(generateCookie(user));

        return true;
    }
}
