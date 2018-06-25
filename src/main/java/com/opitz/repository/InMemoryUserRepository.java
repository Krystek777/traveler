package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value="InMemoryUserRepository")
public class InMemoryUserRepository implements UserRepository {

    private List<User> users;

    public InMemoryUserRepository() {
        users = new ArrayList<>();
        users.add(new User(0,"admin", "admin@opitz.com", "admin"));
        users.add(new User(1,"krystian","krystian@opitz.com","0000"));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public User findUser(String username) {
        return null;
    }
}
