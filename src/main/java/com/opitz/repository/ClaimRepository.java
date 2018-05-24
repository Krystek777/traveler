package com.opitz.repository;


import com.opitz.model.Claim;

import java.util.List;

public interface ClaimRepository {
    List<Claim> getClaims();

    void saveClaim(Claim claim);
}
