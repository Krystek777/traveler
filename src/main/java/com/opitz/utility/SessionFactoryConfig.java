package com.opitz.utility;

import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Log4j
@Component
public class SessionFactoryConfig {

    public SessionFactoryConfig() {
    }

    private static SessionFactory sessionFactoryXML = null;

    public SessionFactory getSession() {

        if(sessionFactoryXML != null) {
            return sessionFactoryXML;
        }

        ServiceRegistry serviceRegistryXML;

        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistryXML = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();

        sessionFactoryXML = configuration.buildSessionFactory(serviceRegistryXML);

        return sessionFactoryXML;


    }




}
