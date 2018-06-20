package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;
import com.opitz.utility.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "HibernateClaimRepository")
public class HibernateClaimRepository implements ClaimRepository {


    @Autowired
    SessionFactoryConfig sessionFactoryConfig;


    @Override
    public List<Claim> getClaims() {

        List<Claim> claimList = new ArrayList<>();

        Session session = sessionFactoryConfig.getSession().openSession();
        List claimL = session.createQuery("from Claim").list();

        for (Object object : claimL) {
            claimList.add((Claim) object);
        }

        session.close();

        return claimList;

    }

    @Override
    public void saveClaim(Claim claim) {

        Session session = sessionFactoryConfig.getSession().openSession();
        Transaction tx = session.beginTransaction();
        session.save(claim);
        session.flush();
        tx.commit();
        session.close();
    }

    @Override
    public void setStatus(Long id, ClaimStatus status) {

    }
}
