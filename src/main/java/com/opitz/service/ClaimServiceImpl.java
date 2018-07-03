package com.opitz.service;


import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;
import com.opitz.repository.ClaimRepository;
import com.opitz.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


public class ClaimServiceImpl implements ClaimService {


    @Setter
    @Autowired
    @Qualifier("HibernateClaimRepository")
    private ClaimRepository claimRepository;

    @Setter
    @Autowired
    @Qualifier("jpaUserRepository")
    @Resource
    private UserRepository userRepository;


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
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUser(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Claim findClaim(long id) {
        return claimRepository.findClaim(id);

    }

    @Transactional
    @Override
    public void remove(User user) {
        userRepository.removeUser(user);
    }


    @Transactional
    @Override
    public void remove(Claim claim) {
        claimRepository.remove(claim);
    }
}
