package com.opitz.repository;

import com.opitz.model.User;
import com.opitz.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository(value = "HibernateUserRepository")
public class HibernateUserRepository implements UserRepository {


    public List<User> getUsers() throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<User> userList = new ArrayList<>();
        List userL = session.createQuery("from User").list();

        for (Object object : userL) {
            userList.add((User) object);
        }


        session.getTransaction().commit();
        session.close();


     return userList;

    }


    @Override
    public void saveUser(User user) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.flush();
        session.getTransaction().commit();
        session.close();

    }
}
