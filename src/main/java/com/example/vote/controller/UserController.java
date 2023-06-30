package com.example.vote.controller;

import com.example.vote.Util;
import com.example.vote.dto.UserDto;
import com.example.vote.dto.UserLoginDto;
import com.example.vote.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    private static final int COOKIE_LIFE_TIME_SEC = 30;

    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    private Cookie generateCookie(com.example.vote.user.User user) {
        Cookie cookie = new Cookie("id", user.getId().toString());

        cookie.setMaxAge(COOKIE_LIFE_TIME_SEC);
        cookie.setDomain("localhost");
        cookie.setPath("/");

        return cookie;
    }

    @PostMapping("users/logout")
    public void logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("id", null);

        cookie.setMaxAge(0);

        response.addCookie(cookie);
    }

    @PostMapping("users/login")
    public boolean login(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response) {
        com.example.vote.user.User user = service.findByEmail(userLoginDto.getEmail());

        if (user == null || !user.getPw().equals(Util.crypto(userLoginDto.getPw()))) return false;

        response.addCookie(generateCookie(user));

        return true;
    }

    @PostMapping("/users/signup")
    public boolean signUp(@RequestBody UserDto userDto) {
        return service.join(userDto);
    }

    @GetMapping("/users")
    public Object getUsers() {
        return service.getAllUsers();
    }
}
