package com.opitz.repository;




import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.ClaimType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class InMemoryClaimRepository implements ClaimRepository {

    private List<Claim> claims;

    public InMemoryClaimRepository() {

        claims = new ArrayList<>();

        claims.add(new Claim(1,"car problem", "john@gmail.com",
                "126534", ClaimType.LOST_BAGGAGE,1, new Date(118,10,10), ClaimStatus.NEW));

        claims.add(new Claim(2,"wrong ticket", "bob@gmail.com",
                "36534", ClaimType.ACCIDENT,1,new Date(120,10,18),ClaimStatus.NEW));

        claims.add(new Claim(3,"toothpaste lost", "kevin@gmail.com",
                "626534", ClaimType.ACCIDENT,1,new Date(122,10,11),ClaimStatus.NEW));

    }

    @Override
    public void saveClaim(Claim claim) {
        claims.add(claim);
    }

    @Override
    public List<Claim> getClaims() {
        return claims;
    }

}
