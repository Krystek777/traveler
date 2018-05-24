package com.opitz.repository;




import com.opitz.model.Claim;
import com.opitz.model.ClaimStatusString;
import com.opitz.model.ClaimTypeString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class InMemoryClaimRepository implements ClaimRepository {

    private List<Claim> claims;

    public InMemoryClaimRepository() {

        claims = new ArrayList<>();

        claims.add(new Claim("car problem", "john@gmail.com",
                "126534", ClaimTypeString.LOST_BAGGAGE,1, new Date(2010,10,10), ClaimStatusString.NEW));

        claims.add(new Claim("wrong ticket", "bob@gmail.com",
                "36534", ClaimTypeString.ACCIDENT,1,new Date(2010,10,18),ClaimStatusString.NEW));

        claims.add(new Claim("toothpaste lost", "kevin@gmail.com",
                "626534", ClaimTypeString.ACCIDENT,1,new Date(2010,10,11),ClaimStatusString.NEW));

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
