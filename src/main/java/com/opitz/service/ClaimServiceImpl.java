package com.opitz.service;


import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;
import com.opitz.repository.ClaimRepository;
import com.opitz.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("claimService")
public class ClaimServiceImpl implements ClaimService {


    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
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
}
