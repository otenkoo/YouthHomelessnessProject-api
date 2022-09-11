package com.valencia.youthhomelessnessprojectapi.services;

import com.valencia.youthhomelessnessprojectapi.models.User;

import java.util.List;

public interface UserService {

    // CREATE
    User saveUser(User admin);

    // READ
    User getUserById(Long id);

    User getUserByUsername(String username);

    List<User> getAllUsers();

    // DELETE
    void deleteUserById(Long id);
}
