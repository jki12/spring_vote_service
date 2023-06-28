package com.example.vote.post;

import com.example.vote.user.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
}
