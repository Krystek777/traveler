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

    public void setStatus(long id, ClaimStatus status);

    public User findUser(String username);

    public User findUser(long id);

    public Claim findClaim(long id);


    void remove(User user);

    void remove(Claim claim);
}
