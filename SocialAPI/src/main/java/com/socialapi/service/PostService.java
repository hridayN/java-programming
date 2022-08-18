package com.socialapi.service;

import com.socialapi.models.Location;
import com.socialapi.models.Post;
import com.socialapi.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService implements IPostService {
    User user1 = new User("u1", "Jany", "Lawrence", new Location("l1", "Lagos"), "Jany@gmail.com");
    User user2 = new User("u2", "Jadon", "Mills", new Location("l2", "Asaba"), "Jadon@gmail.com");

    Post post1 = new Post("p1", "01-Jan-19", user1, "Its good to love and be loved");
    Post post2 = new Post("p2", "02-Jan-19", user2, "We all need someone");
    List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2));

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post getPostById(String id) {
        return posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }
}
