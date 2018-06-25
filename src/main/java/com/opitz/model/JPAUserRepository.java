package com.opitz.model;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JPAUserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    List<User> findAll();

    User saveAndFlush();



}
