package com.opitz.repository;


import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;

import java.util.List;

public interface ClaimRepository {


    List<Claim> getClaims();

    void saveClaim(Claim claim);

    void setStatus(Long id, ClaimStatus status);

    Claim findClaim(long id);
}
