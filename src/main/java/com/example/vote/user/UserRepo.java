package com.example.vote.user;

import com.example.vote.dto.UserDto;
import com.example.vote.user.User;

import java.util.Collection;

public interface UserRepo {
    boolean save(UserDto userDto);

    User findByEmail(String email);

    User findByName(String name);

    Collection<User> getUsers(); // for test.
}
