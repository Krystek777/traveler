package com.opitz.repository;

import com.opitz.utility.PersistenceContext;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
@WebAppConfiguration
public class InMemoryUserRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @org.junit.Test
    public void getUsers() {
    }

    @org.junit.Test
    public void saveUser() {
    }

    @org.junit.Test
    public void findUser() {
    }
}