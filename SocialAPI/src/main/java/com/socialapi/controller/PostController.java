package com.socialapi.controller;

import com.socialapi.models.Post;
import com.socialapi.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private IPostService postService;

    @RequestMapping(value = "/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @RequestMapping(value = "/post/{id}")
    public Post getPostById(@PathVariable String id) {
        return postService.getPostById(id);
    }

    @PostMapping(value = "/posts/add")
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }
}
