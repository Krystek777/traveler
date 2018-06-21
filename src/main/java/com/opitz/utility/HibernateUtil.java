package com.opitz.utility;

import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author imssbora
 */

@Log4j
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();
                }
            }

        return sessionFactory;
    }

}