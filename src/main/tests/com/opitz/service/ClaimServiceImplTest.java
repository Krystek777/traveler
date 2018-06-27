package com.opitz.service;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.User;
import com.opitz.repository.HibernateClaimRepositoryTest;
import com.opitz.repository.HibernateUserRepositoryTest;
import com.opitz.utility.PersistenceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class ClaimServiceImplTest {

    @Autowired
    private ClaimService claimService;


    @Test
    public void getClaims() {

        List<Claim> claims =  claimService.getClaims();
        assertNotNull(claims);

    }

    @Test
    public void getUsers() {
        List<User> users = claimService.getUsers();
        assertNotNull(users);
    }

    @Test
    public void saveClaim() {
        HibernateClaimRepositoryTest claimTest = new HibernateClaimRepositoryTest();
        int size = claimService.getClaims().size();
        Claim claim = claimTest.getMockClaim();
        claimService.saveClaim(claim);

        assertEquals(size, claimService.getClaims().size() - 1);


    }

    @Test
    public void saveUser() {
        HibernateUserRepositoryTest userTest = new HibernateUserRepositoryTest();
        int size = claimService.getUsers().size();
        User user = userTest.getMockUser();
        claimService.saveUser(user);

        assertEquals(size, claimService.getUsers().size() - 1);
    }


}