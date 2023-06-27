package com.example.vote.controller;

import com.example.vote.dto.UserDto;
import com.example.vote.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class Register {
    private static final UserRepo repo = new MemoryUserRepo();

    @PostMapping("/users/signup") // url design ref : github(signup), stackoverflow(users/signup)
    public Object signUp(@RequestBody UserDto userDto) {

        return repo.save(userDto);
    }

    @GetMapping("/users")
    public Object getUsers() {
        return repo.getUsers();
    }
}
