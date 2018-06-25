package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "HibernateUserRepository")
public class HibernateUserRepository implements UserRepository {


    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getUsers() throws HibernateException {
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.flush();
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public User findUser(String username) {
        List<User> users = new ArrayList<>();

        try {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            query.select(root);
            query.where(builder.equal(root.get("username"), username));
            Query<User> q = session.createQuery(query);
            users = q.getResultList();

            session.getTransaction().commit();
            session.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return users.get(0);
    }

}
