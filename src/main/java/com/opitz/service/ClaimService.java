package com.opitz.service;


import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;
import com.opitz.repository.ClaimRepository;
import com.opitz.repository.UserRepository;
import com.opitz.utility.ServiceLocator;

import java.util.List;

public class ClaimService {


    private ClaimRepository repository;

    public List<Claim> getClaims() {
        ClaimRepository repository = ServiceLocator.findClaimRepository();
        return repository.getClaims();
    }


    public List<User> getUsers() {
        UserRepository repository = ServiceLocator.findUserRepository();
        return repository.getUsers();
    }

    public void saveClaim(Claim claim) {
        ClaimRepository repository = ServiceLocator.findClaimRepository();
        repository.saveClaim(claim);
    }

    public void saveUser(User user) {
        UserRepository repository = ServiceLocator.findUserRepository();
        repository.saveUser(user);

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
}
