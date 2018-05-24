package com.opitz.repository;

import com.opitz.model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private List<User> users;

    @Override
    public List<User> getUsers() {
        users = new ArrayList<>();

        users.add(new User("admin", "admin"));
        users.add(new User("krystian","0000"));
        return users;
    }
}
