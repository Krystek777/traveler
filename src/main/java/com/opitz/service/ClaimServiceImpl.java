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


    @Autowired
    @Qualifier("HibernateClaimRepository")
    private ClaimRepository claimRepository;

    @Autowired
    @Qualifier("HibernateUserRepository")
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

        claimRepository.setStatus(id, status);
    }

    public User findUser(String username) {
        for(User user: getUsers()) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }






}
