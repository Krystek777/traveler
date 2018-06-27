package com.opitz.action;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.service.ClaimService;
import com.opitz.utility.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import servletunit.struts.MockStrutsTestCase;


import java.io.File;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class UpdateClaimActionTest extends MockStrutsTestCase {

    @Autowired
    ClaimService claimService;

    @Before
    public void initialize() {
        try {
            setUp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setContextDirectory(new File("src/main/webapp"));
    }

    @Test
    public void rejectClaim() {

        List<Claim> claims = claimService.getClaims();
        Claim claim = claims.get(0);
        ClaimStatus claimStatus = claim.getStatus();
        setStatus("rejectClaim");
        claims = claimService.getClaims();
        claim = claims.get(0);
        assertEquals(claim.getStatus(), ClaimStatus.REJECTED);
        claimService.setStatus(claim.getId(), claimStatus);
    }

    @Test
    public void approveClaim() {
        List<Claim> claims = claimService.getClaims();
        Claim claim = claims.get(0);
        ClaimStatus claimStatus = claim.getStatus();
        setStatus("approveClaim");
        claims = claimService.getClaims();
        claim = claims.get(0);
        assertEquals(claim.getStatus(), ClaimStatus.APPROVED);
        claimService.setStatus(claim.getId(), claimStatus);

    }


    @Transactional
    public void setStatus(String actionType) {
        List<Claim> claims = claimService.getClaims();
        if (claims.isEmpty()) {
            fail();
        }

        Claim claim = claims.get(0);

        setRequestPathInfo("/" + actionType);
        request.addParameter("id", Long.toString(claim.getId()));
        actionPerform();

    }


}
