package com.socialapi.service;

import com.socialapi.models.Post;

import java.util.List;

public interface IPostService {
    List<Post> getAllPosts();

    Post getPostById(String id);

    void addPost(Post post);
}
