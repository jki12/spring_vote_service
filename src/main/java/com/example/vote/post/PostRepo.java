package com.example.vote.post;

import java.util.ArrayList;

public interface PostRepo {
    void save(Post post);

    ArrayList<Post> findByUserName(String userName);
}
