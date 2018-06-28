package com.opitz.action;

import com.opitz.form.LoginForm;
import com.opitz.form.SignUpForm;
import com.opitz.model.Claim;
import com.opitz.model.User;
import com.opitz.service.ClaimService;
import com.opitz.utility.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import servletunit.struts.MockStrutsTestCase;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class UserActionTest extends MockStrutsTestCase {

    private LoginForm form;

    private SignUpForm signUpForm;

    @Autowired
    private ClaimService claimService;

    @Before
    public void initialize() {
        try {
            setUp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setContextDirectory(new File("src/main/webapp"));
        form = new LoginForm();
        signUpForm = new SignUpForm();
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
    public void saveUserSuccess() {

        String username ="abc123$";
        String email = "abc123@opitz.com";
        String password ="1234";

        setRequestPathInfo("/saveUser");
        signUpForm.setUsername(username);
        signUpForm.setEmail(email);
        signUpForm.setPassword(password);
        signUpForm.setConfirmPassword(password);

        List<User> users = claimService.getUsers();
        for(User user: users) {
            if(user.getUsername().equals(username) || user.getEmail().equals(email)) {
                fail();
            }
        }

        setActionForm(signUpForm);
        actionPerform();
        verifyTilesForward("success","signUp.td");
        verifyNoActionErrors();
        claimService.remove(claimService.findUser(username));

    }


    @Test
    public void saveUserLenghtError() {
        String username ="admin";
        String email = "admin@opitz.com";
        String password ="1234";

        setRequestPathInfo("/saveUser");
        signUpForm.setUsername(username);
        signUpForm.setEmail(email);
        signUpForm.setPassword(password);
        signUpForm.setConfirmPassword(password);

        setActionForm(signUpForm);
        actionPerform();

        verifyActionErrors(new String[] {"error.username.exists"});
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