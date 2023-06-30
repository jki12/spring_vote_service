package com.example.vote.post;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MemoryPostRepo implements PostRepo {
    private final ArrayList<Post> repo = new ArrayList<>();

    @Override
    public void save(Post post) {
        repo.add(post);
    }

    @Override
    public ArrayList<Post> findByUserName(String userName) {
        ArrayList<Post> res = new ArrayList<Post>();

        for (var post : repo) if (post.getUser().getName().equals(userName)) res.add(post);

        return res;
    }

    @Override
    public ArrayList<Post> getPosts() {
        return repo;
    }
}
