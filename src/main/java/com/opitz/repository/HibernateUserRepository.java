package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "HibernateUserRepository")
public class HibernateUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers() throws HibernateException {
        return entityManager.createQuery( "from User", User.class ).getResultList();

    }


    @Override
    public void saveUser(User user) throws HibernateException {

        entityManager.persist(user);

    }

    @Override
    public User findUser(String username) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.where(builder.equal(root.get("username"), username));

        return entityManager.createQuery(query).getSingleResult();

    }

}
