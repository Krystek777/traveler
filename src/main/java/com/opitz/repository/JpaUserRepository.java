package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("JpaUserRepository")
public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository  {



    @Override
    default List<User> getUsers() {
        return findAll();
    }

    @Override
    default void saveUser(User user) {
            save(user);
    }
}
