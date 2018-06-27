package com.opitz.action;

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
    public void testLogin() {
        setRequestPathInfo("/login");
        actionPerform();
        verifyTilesForward("success", "login.td");
    }


}
