package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "HibernateClaimRepository")
public class HibernateClaimRepository implements ClaimRepository {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Claim> getClaims() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Claim> claimList = new ArrayList<>();
        List claimL = session.createQuery("from Claim").list();

        for (Object object : claimL) {
            claimList.add((Claim) object);
        }


        session.getTransaction().commit();
        session.close();


        return claimList;

    }

    @Override
    public void saveClaim(Claim claim) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(claim);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void setStatus(Long id, ClaimStatus status) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Claim claim = (Claim)session.get(Claim.class, id);
        claim.setStatus(status);
        session.saveOrUpdate(claim);
        session.getTransaction().commit();
        session.close();
    }
}
