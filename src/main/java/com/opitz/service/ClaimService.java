package com.opitz.service;


import com.opitz.model.Claim;
import com.opitz.repository.ClaimRepository;
import com.opitz.utility.ServiceLocator;

import java.util.List;

public class ClaimService {

    public List<Claim> getClaims() {
        ClaimRepository repository = ServiceLocator.findClaimRepository();
        return repository.getClaims();
    }

    public void saveClaim(Claim claim) {
        ClaimRepository repository = ServiceLocator.findClaimRepository();
        repository.saveClaim(claim);
    }

    public void setStatus(Long id, String status) {
        for(Claim claim: getClaims()) {
            if(claim.getId() == id) {
                claim.setStatus(status);
            }
        }
    }
}
