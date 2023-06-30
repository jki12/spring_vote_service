package com.example.vote.controller;

import com.example.vote.dto.PostDto;
import com.example.vote.post.PostService;
import com.example.vote.user.User;
import com.example.vote.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.UUID;

@RestController
public class PostController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final PostService postService;

    public PostController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Object getPosts() {
        return postService.getPosts();
    }

    @PostMapping("posts/new")
    public boolean submitPost(@CookieValue(value = "id") Cookie cookie, @RequestBody PostDto postDto) {
        try {

            User user = userService.findById(UUID.fromString(cookie.getValue()));

            if (user == null) return false; // posting 권한 없음..

            postService.save(user, postDto);

            return true;

        } catch (IllegalArgumentException e) {

            return false;
        }
    }
}
