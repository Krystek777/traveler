package com.opitz.action;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.service.ClaimService;
import com.opitz.utility.PersistenceContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import servletunit.struts.MockStrutsTestCase;


import java.io.File;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class UpdateClaimActionTest extends MockStrutsTestCase {

    @Autowired
    private ClaimService claimService;

    private ClaimStatus claimStatusDefault;

    private List<Claim> claims;

    private Claim claim;

    @Before
    public void initialize() {
        try {
            setUp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setContextDirectory(new File("src/main/webapp"));

        List<Claim> claims = claimService.getClaims();
        claim = claims.get(0);
        claimStatusDefault = claim.getStatus();

        claims = claimService.getClaims();
        if (claims.isEmpty()) {
            fail();
        }

        claim = claims.get(0);


    }

    @Test
    public void rejectClaim() {
        setRequestPathInfo("/rejectClaim");
        request.addParameter("id", Long.toString(claim.getId()));
        actionPerform();

        claims = claimService.getClaims();
        claim = claims.get(0);
        assertEquals(claim.getStatus(), ClaimStatus.REJECTED);
    }

    @Test
    public void approveClaim() {

        setRequestPathInfo("/approveClaim");
        request.addParameter("id", Long.toString(claim.getId()));
        actionPerform();

        claims = claimService.getClaims();
        claim = claims.get(0);
        assertEquals(claim.getStatus(), ClaimStatus.APPROVED);


    }



    @After
    public void runAfter() {
        claimService.setStatus(claim.getId(), claimStatusDefault);

    }



}
