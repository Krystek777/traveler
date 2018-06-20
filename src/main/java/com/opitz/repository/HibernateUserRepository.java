package com.opitz.repository;

import com.opitz.model.User;
import com.opitz.utility.SessionFactoryConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "HibernateUserRepository")
public class HibernateUserRepository implements UserRepository {

    @Autowired
    SessionFactoryConfig sessionFactoryConfig;


    public List<User> getUsers() throws HibernateException {

        List<User> userList = new ArrayList<>();

        Session session = sessionFactoryConfig.getSession().openSession();
        List userL = session.createQuery("from User").list();

        for (Object object : userL) {
            userList.add((User) object);
        }

        session.close();

        return userList;

    }


    @Override
    public void saveUser(User user) throws HibernateException {

        Session session = sessionFactoryConfig.getSession().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        session.flush();
        tx.commit();
        session.close();

    }
}
