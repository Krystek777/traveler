package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "HibernateClaimRepository")
public class HibernateClaimRepository implements ClaimRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Claim> getClaims() {
        return entityManager.createQuery( "from Claim", Claim.class ).getResultList();

    }

    @Override
    public void saveClaim(Claim claim) {
        entityManager.merge(claim);
    }

    @Override
    public void setStatus(Long id, ClaimStatus status) {
        Claim claim = entityManager.find(Claim.class,id);
        claim.setStatus(status);
        entityManager.merge(claim);
    }
}
