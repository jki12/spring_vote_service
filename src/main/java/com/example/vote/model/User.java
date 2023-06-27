package com.example.vote.model;

import com.example.vote.Util;
import com.example.vote.dto.UserDto;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class User {
    private final UUID id;

    private String email;
    private String pw;
    private String name;

    public User(UserDto userDto) {
        id = UUID.randomUUID();

        this.email = userDto.getEmail();
        this.pw = userDto.getPw(); // need to hashing.
        this.name = userDto.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Util.hash(id);
    }
}
