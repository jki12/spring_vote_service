package com.example.vote.user;

import com.example.vote.dto.UserDto;

import java.util.Collection;
import java.util.UUID;

public interface UserService {

    boolean join(UserDto userDto);
    User findById(UUID id);

    User findByEmail(String email);
    Collection<User> getAllUsers();
}
