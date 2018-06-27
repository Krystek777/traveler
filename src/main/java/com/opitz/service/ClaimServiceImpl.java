package com.opitz.service;


import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;
import com.opitz.repository.ClaimRepository;
import com.opitz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class ClaimServiceImpl implements ClaimService {


    @Autowired
    @Qualifier("HibernateClaimRepository")
    private ClaimRepository claimRepository;

    @Autowired
    @Qualifier("HibernateUserRepository")
    private UserRepository userRepository;

//    @Autowired
//    JPAUserRepository jpaUserRepository;

    @Override
    public List<Claim> getClaims() {
        return claimRepository.getClaims();
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Transactional
    @Override
    public void saveClaim(Claim claim) {
        claimRepository.saveClaim(claim);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Transactional
    @Override
    public void setStatus(long id, ClaimStatus status) {
        claimRepository.setStatus(id, status);
    }

    @Override
    public User findUser(String username) {
        return userRepository.findUser(username);
    }

    @Override
    public User findUser(long id) {
        return userRepository.findUser(id);
    }

    @Override
    public Claim findClaim(long id) {
        return claimRepository.findClaim(id);

    }
}
