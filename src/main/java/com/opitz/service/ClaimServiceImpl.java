package com.opitz.service;


import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;
import com.opitz.repository.ClaimRepository;
import com.opitz.repository.UserRepository;
import lombok.Data;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Service("claimService")
public class ClaimServiceImpl implements ClaimService {

    private static SessionFactory sessionFactoryXML = null;
    private static ServiceRegistry serviceRegistryXML= null;


    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    @Qualifier("InMemoryUserRepository")
    private UserRepository userRepository;

    public List<Claim> getClaims() {
        return claimRepository.getClaims();
    }


    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public void saveClaim(Claim claim) {
        claimRepository.saveClaim(claim);
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public void setStatus(Long id, ClaimStatus status) {
        for(Claim claim: getClaims()) {
            if(claim.getId() == id) {
                claim.setStatus(status);
            }
        }
    }

    public User findUser(String username) {
        for(User user: getUsers()) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistryXML = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();

        sessionFactoryXML = configuration.buildSessionFactory(serviceRegistryXML);

        return sessionFactoryXML;
    }


    public List<User> listUsers() {
        configureSessionFactory();
        Session session = null;

        List<User> userList = new ArrayList<>();

        try {
            session = sessionFactoryXML.openSession();
            List userL = session.createQuery("from User where username='Kazik'").list();

            for (Object object : userL) {
                userList.add((User)object);
                User user = (User)object;
                System.out.println("Username: " + user.getUsername() + " | Email:"  + user.getEmail() + " Password:" + user.getPassword());
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally{
            if(session != null) {
                session.close();
            }
        }
        return userList;

    }

}
