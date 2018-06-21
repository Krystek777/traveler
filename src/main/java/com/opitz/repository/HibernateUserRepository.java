package com.opitz.repository;

import com.opitz.model.User;
import com.opitz.utility.HibernateSessionFactory;
import com.opitz.utility.SessionFactoryConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "HibernateUserRepository")
public class HibernateUserRepository implements UserRepository {




    public List<User> getUsers() throws HibernateException {

        List<User> userList = new ArrayList<>();

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List userL = session.createQuery("from User").list();

        for (Object object : userL) {
            userList.add((User) object);
        }

        HibernateSessionFactory.shutdown();
        System.out.println(userList);

     return userList;

    }


    @Override
    public void saveUser(User user) throws HibernateException {



    }
}
