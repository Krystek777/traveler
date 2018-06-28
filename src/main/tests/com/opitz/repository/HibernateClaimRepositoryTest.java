package com.opitz.repository;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.ClaimType;
import com.opitz.utility.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class HibernateClaimRepositoryTest {

    @Autowired
    @Qualifier("HibernateClaimRepository")
    private ClaimRepository claimRepository;

    private Claim claim;

    public Claim getMockClaim() {
        String name = "myClaim";
        String email = "email@email.com";
        String policy = "231453";
        ClaimType claimType = ClaimType.ILLNESS;
        int claimAmount = 1;
        Date dateOccurred = new Date(40, 6, 12);
        ClaimStatus claimStatus = ClaimStatus.NEW;
        return new Claim(name, email, policy, claimType, claimAmount, dateOccurred, claimStatus);
    }

    @Before
    public void initialize() {
        claim = getMockClaim();
    }

    @Test
    @Transactional
    public void getClaims() {

        List<Claim> claims = claimRepository.getClaims();
        assertTrue(claims.size() > 0);

        int size = claims.size();
        claimRepository.saveClaim(claim);
        assertEquals(size, claimRepository.getClaims().size() - 1);
    }

    @Test
    @Transactional
    public void saveClaim() {
        claimRepository.saveClaim(claim);
        List<Claim> claims = claimRepository.getClaims();
        assertTrue(claims.contains(claim));

    }

    @Test
    @Transactional
    public void setStatus() {
        List<Claim> claims = claimRepository.getClaims();
        if (claims.isEmpty()) {
            fail();
        }

        Claim first = claims.get(0);

        claimRepository.setStatus(first.getId(), ClaimStatus.APPROVED);
        assertEquals(first.getStatus(), ClaimStatus.APPROVED);

        claimRepository.setStatus(first.getId(), ClaimStatus.REJECTED);
        assertEquals(first.getStatus(), ClaimStatus.REJECTED);

    }
}