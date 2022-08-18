package com.socialapi.service;

import com.socialapi.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getUserById(String id);

    void addUser(User user);
}
