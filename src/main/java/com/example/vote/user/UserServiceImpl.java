package com.example.vote.user;

import com.example.vote.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo repo;

    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean join(UserDto userDto) {
        if (repo.findByEmail(userDto.getEmail()) != null) return false; // 중복 검증.

        System.out.println(repo.getClass().getName());

        return repo.save(new User(userDto));
    }

    @Override
    public User findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return repo.getUsers();
    }
}
