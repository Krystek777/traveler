package com.opitz.repository;

import com.opitz.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    void saveUser(User user);

    User findUser(String username);

    User findUser(long id);

    void remove(User user);
}
