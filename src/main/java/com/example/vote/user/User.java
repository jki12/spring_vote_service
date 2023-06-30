package com.example.vote.user;

import com.example.vote.Util;
import com.example.vote.dto.UserDto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity @Table(name = "Users")
@Getter
public class User {
    private static int count = 0;

    @Id
    private final UUID id;

    private String email;
    private String pw;
    private String name;

    public User(UserDto userDto) {
        count++;

        id = UUID.randomUUID();

        this.email = userDto.getEmail();
        this.pw = Util.crypto(userDto.getPw());
        this.name = userDto.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return (id == user.id);
    }

    @Override
    public int hashCode() {
        return Util.hash(id);
    }
}
