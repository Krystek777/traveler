package com.opitz.service;


import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;

import java.util.List;

public interface ClaimService {

    public List<Claim> getClaims();


    public List<User> getUsers();

    public void saveClaim(Claim claim);

    public void saveUser(User user);

    public void setStatus(Long id, ClaimStatus status);

    public User findUser(String username);
}
