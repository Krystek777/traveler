package com.opitz.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Deprecated
public class App
{
    public static void connect( )
    {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        tx.commit();
        session.close();
    }
}
