package com.opitz.repository;

import com.opitz.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Claim repository based on Hibernate.
 */


@Repository
public interface JpaClaimRepository extends JpaRepository<Claim, Long>, ClaimRepository {

    @Override
    default void saveClaim(Claim claim) {
        save(claim);
    }

    @Override
    default List<Claim> getClaims() {
        return findAll();
    }
}

