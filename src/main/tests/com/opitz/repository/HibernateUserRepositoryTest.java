package com.opitz.repository;

import com.opitz.model.User;
import com.opitz.utility.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class HibernateUserRepositoryTest {

    @Autowired
    @Qualifier("HibernateUserRepository")
    private UserRepository userRepository;

    private  User user;
    private  List<User> users;
    private final String existingUsername = "admin";

    public User getMockUser() {
        String username = "xyz$qrt123zxc";
        String email = "xyz$qrt123zxc@opitz.com";
        String password = "0000";

        return new User(username, email, password);

    }

    @Before
    public void initlialize() {

        List<User> users = userRepository.getUsers();
        user = getMockUser();

        for(User u: users) {
            if(u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail())) {
                fail();
            }
        }


    }

    @Test
    @Transactional
    public void getUsers() {
        List<User> users = userRepository.getUsers();
        assertTrue(users.size() > 0);
        int size = users.size();
        userRepository.saveUser(user);
        assertEquals(size, userRepository.getUsers().size() - 1);
    }

    @Test(expected = PersistenceException.class)
    @Transactional
    public void saveUser() {

        userRepository.saveUser(user);
        assertNotNull(userRepository.findUser(user.getUsername()));

        User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
        userRepository.saveUser(newUser);
    }

    @Test
    @Transactional
    public void findUserByUsername() {
        userRepository.findUser(existingUsername);
        userRepository.saveUser(user);
        userRepository.findUser(user.getUsername());
    }

    @Test
    @Transactional
    public void findUserById () {
        userRepository.saveUser(user);
        User foundUser = userRepository.findUser(user.getId());
        assertEquals(foundUser.getUsername(), user.getUsername());
    }
}