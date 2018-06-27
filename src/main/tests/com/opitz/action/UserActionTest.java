package com.opitz.action;

import com.opitz.form.LoginForm;
import com.opitz.utility.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import servletunit.struts.MockStrutsTestCase;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class UserActionTest extends MockStrutsTestCase {

    private LoginForm form;

    @Before
    public void initialize() {
        try {
            setUp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setContextDirectory(new File("src/main/webapp"));
        form = new LoginForm();
    }


    @Test
    public void login() {
        setRequestPathInfo("/login");
        actionPerform();
        verifyTilesForward("success","login.td");
    }




    @Test
    public void loginSubmitSuccess() {

        setRequestPathInfo("/loginSubmit");
        form.setUsername("admin");
        form.setPassword("admin");
        setActionForm(form);
        actionPerform();
        verifyTilesForward("success", "welcome.td");


    }

    @Test
    public void loginSubmitFailure() {

        setRequestPathInfo("/loginSubmit");
        form.setUsername("xxx");
        form.setPassword("yyy");
        setActionForm(form);
        actionPerform();
        verifyTilesForward("failure", "login.td");
        verifyActionErrors(new String[] {"error.wrong.username.password"});


    }

    @Test
    public void signUp() {
        setRequestPathInfo("/signUp");
        actionPerform();
        verifyTilesForward("success", "signUp.td");

    }

    @Test
    public void saveUser() {


    }

    @Test
    public void signOut() {
        setRequestPathInfo("/signOut");
        actionPerform();
        assertNull(getSession().getAttribute("loggedUser"));
        verifyTilesForward("success","welcome.td");
    }

    @Test
    public void welcome() {
        setRequestPathInfo("/welcome");
        actionPerform();
        verifyTilesForward("success","welcome.td");
    }
}