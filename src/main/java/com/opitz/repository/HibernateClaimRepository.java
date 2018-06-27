package com.opitz.repository;
import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HibernateClaimRepository implements ClaimRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Claim> getClaims() {
        return entityManager.createQuery("from Claim", Claim.class).getResultList();
    }

    @Override
    public void saveClaim(Claim claim) {
        entityManager.merge(claim);
    }

    @Override
    public void setStatus(Long id, ClaimStatus status) {
        Claim claim = entityManager.find(Claim.class, id);
        claim.setStatus(status);
        entityManager.merge(claim);
    }
}
