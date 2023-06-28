package com.example.vote.controller;

import com.example.vote.dto.UserDto;
import com.example.vote.user.MemoryUserRepo;
import com.example.vote.user.User;
import com.example.vote.user.UserRepo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

@RestController
public class SignUp {
    private static final UserRepo repo = new MemoryUserRepo();

    @PostMapping("/users/signup") // url design ref : github(signup), stackoverflow(users/signup)
    public Object signUp(@RequestBody UserDto userDto) {

        return repo.save(userDto);
    }

    @GetMapping("/users")
    public Object getUsers() {
        return repo.getUsers(); // admin use only.
    }
}
