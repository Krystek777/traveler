package com.opitz.repository;

import com.opitz.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    void saveUser(User user);

    User findByUsername(String username);

    User findById(long id);

    void removeUser(User user);
}
