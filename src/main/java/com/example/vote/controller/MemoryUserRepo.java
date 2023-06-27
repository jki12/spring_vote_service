package com.example.vote.controller;

import com.example.vote.dto.UserDto;
import com.example.vote.model.User;

import java.util.Collection;
import java.util.HashSet;

public class MemoryUserRepo implements UserRepo {
    private final HashSet<User> users = new HashSet<>();
    @Override
    public boolean save(UserDto userDto) {
        if (findByEmail(userDto.getEmail()) != null) return false;

        boolean res = users.add(new User(userDto));

        assert (res);

        return true;
    }

    @Override
    public User findByEmail(String email) {
        for (var user : users) if (user.getEmail().equals(email)) return user;

        return null;
    }

    @Override
    public User findByName(String name) {
        for (var user : users) if (user.getName().equals(name)) return user;

        return null;
    }

    @Override
    public Collection getUsers() {
        return users;
    }
}
