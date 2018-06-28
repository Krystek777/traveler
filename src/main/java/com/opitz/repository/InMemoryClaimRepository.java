package com.opitz.repository;




import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.ClaimType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Deprecated
@Component
public class InMemoryClaimRepository implements ClaimRepository {

    private List<Claim> claims;

    public InMemoryClaimRepository() {

        claims = new ArrayList<>();

        claims.add(new Claim("car problem", "john@gmail.com",
                "126534", ClaimType.LOST_BAGGAGE,1, new Date(118,10,10), ClaimStatus.NEW));

        claims.add(new Claim("wrong ticket", "bob@gmail.com",
                "36534", ClaimType.ACCIDENT,1,new Date(120,10,18),ClaimStatus.NEW));

        claims.add(new Claim("toothpaste lost", "kevin@gmail.com",
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


    @Override
    public void setStatus(Long id, ClaimStatus status) {

    }

    @Override
    public Claim findClaim(long id) {
        return null;
    }

    @Override
    public void remove(Claim claim) {

    }
}
