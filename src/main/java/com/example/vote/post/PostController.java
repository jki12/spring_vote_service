package com.example.vote.post;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PostController {

    private final PostRepo repo = new MemoryPostRepo();

    @PostMapping("posts/new")
    public boolean uploadPost(@RequestBody Post post) { // post to postDto.

        repo.save(post);

        return true;
    }

    @GetMapping("posts/{userName}")
    public ArrayList<Post> showUserPosts(@PathVariable("userName") String userName) {

        System.out.println(userName);

        return repo.findByUserName(userName);
    }
}
