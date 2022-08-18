package com.socialapi.service;
import com.socialapi.models.Location;
import com.socialapi.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService {
    User user1 = new User("u1", "Jany", "Lawrence", new Location("l1", "Lagos"), "Jany@gmail.com");
    User user2 = new User("u2", "Jadon", "Mills", new Location("l2", "Asaba"), "Jadon@gmail.com");
    List<User> users = new ArrayList<>(Arrays.asList(user1, user2));

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(String id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
