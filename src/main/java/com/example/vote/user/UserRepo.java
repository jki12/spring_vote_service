package com.example.vote.user;

import java.util.Collection;
import java.util.UUID;

public interface UserRepo {
    boolean save(User user);

    User findById(UUID id); // post.

    User findByEmail(String email);

    Collection<User> getUsers(); // for test.
}
