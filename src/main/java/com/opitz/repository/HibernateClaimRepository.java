package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "HibernateClaimRepository")
public class HibernateClaimRepository implements ClaimRepository {




    @Override
    public List<Claim> getClaims() {

      return null;

    }

    @Override
    public void saveClaim(Claim claim) {

    }

    @Override
    public void setStatus(Long id, ClaimStatus status) {

    }
}
