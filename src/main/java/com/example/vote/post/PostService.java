package com.example.vote.post;

import com.example.vote.dto.PostDto;
import com.example.vote.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {
    @Autowired
    private PostRepo repo;

    public PostService(PostRepo repo) {
        this.repo = repo;
    }

    public void save(User user, PostDto postDto) {

        repo.save(new Post(user, postDto));
    }

    public ArrayList<Post> getPosts() {
        return repo.getPosts();

    }
}
