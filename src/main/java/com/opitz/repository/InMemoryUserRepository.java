package com.opitz.repository;

import com.opitz.model.User;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Deprecated
@Component(value="InMemoryUserRepository")
public class InMemoryUserRepository implements UserRepository {

    private List<User> users;

    public InMemoryUserRepository() {
        users = new ArrayList<>();
        users.add(new User("admin", "admin@opitz.com", "admin"));
        users.add(new User("krystian","krystian@opitz.com","0000"));
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
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public void removeUser(User user) {

    }
}
