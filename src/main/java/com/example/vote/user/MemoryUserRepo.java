package com.example.vote.user;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Repository
public class MemoryUserRepo implements UserRepo {
    private final HashSet<User> userEntities = new HashSet<>();

    @Override
    public boolean save(User user) {
        if (findByEmail(user.getEmail()) != null) return false;

        boolean res = userEntities.add(user);

        assert (res);

        return true;
    }

    @Override
    public User findById(UUID id) {
        for (var user : userEntities) if (user.getId().equals(id)) return user;

        return null;
    }

    @Override
    public User findByEmail(String email) {
        for (var user : userEntities) if (user.getEmail().equals(email)) return user;

        return null;
    }

    @Override
    public Collection getUsers() {
        return userEntities;
    }
}
