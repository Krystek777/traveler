package com.opitz.repository;


import com.opitz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository {

    default List<User> getUsers() {
        return findAll();
    }

    default void saveUser(User user) {
        save(user);
    }


    default void removeUser(User user) {
        delete(user);
    }

}
