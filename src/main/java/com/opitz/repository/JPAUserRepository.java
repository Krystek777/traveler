package com.opitz.repository;


import com.opitz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface JPAUserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    List<User> findAll();

    User saveAndFlush();



}
