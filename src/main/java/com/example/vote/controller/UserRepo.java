package com.example.vote.controller;

import com.example.vote.dto.UserDto;
import com.example.vote.model.User;

import java.util.Collection;

public interface UserRepo {
    boolean save(UserDto userDto);

    User findByEmail(String email);

    User findByName(String name);

    Collection<User> getUsers(); // for test.
}
