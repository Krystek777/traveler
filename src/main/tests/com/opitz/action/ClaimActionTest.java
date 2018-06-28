package com.opitz.action;

import com.opitz.form.ClaimForm;
import com.opitz.model.Claim;
import com.opitz.service.ClaimService;
import com.opitz.utility.PersistenceContext;
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
public class ClaimActionTest extends MockStrutsTestCase {

    @Autowired
    ClaimService claimService;

    private ClaimForm claimForm;

    @Before
    public void initialize() {
        try {
            setUp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setContextDirectory(new File("src/main/webapp"));
        claimForm = new ClaimForm();
    }


    @Test
    public void addClaim() {
        setRequestPathInfo("/addClaim");
        ClaimForm claimForm = new ClaimForm();
        setActionForm(claimForm);
        verifyTilesForward("success","addClaim.td");
        verifyNoActionErrors();
    }


    @Test
    public void addClaimSubmit() {

        claimForm.setName("myClaim");
        claimForm.setEmail("myEmail@email.com");
        claimForm.setPolicy("321432");
        claimForm.setClaimType("LOST_BAGGAGE");
        claimForm.setClaimAmount("1");
        claimForm.setDateOccurred("2012/10/11");

        setRequestPathInfo("/addClaimSubmit");
        setActionForm(claimForm);
        actionPerform();

        verifyForward("success");
        verifyNoActionErrors();

        List<Claim> claims = claimService.getClaims();
        Claim claim = claims.get(claims.size() - 1);
        claimService.remove(claimService.findClaim(claim.getId()));


    }



    @Test
    public void allClaims() {
        setRequestPathInfo("/allClaims");
        actionPerform();
        verifyTilesForward("success", "allClaims.td");
        verifyNoActionErrors();

    }


}