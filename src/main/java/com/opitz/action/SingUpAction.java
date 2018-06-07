package com.opitz.action;

import com.opitz.form.SingUpForm;
import com.opitz.model.User;
import com.opitz.service.ClaimService;
import com.opitz.utility.ServiceLocator;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SingUpAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClaimService claimService = ServiceLocator.findClaimService();
        SingUpForm singUpForm = (SingUpForm) form;
        ActionRedirect failureRedirect = new ActionRedirect(mapping.findForward("failure"));

        if (!singUpForm.getPassword().equals(singUpForm.getConfirmPassword())) {

            failureRedirect.addParameter("message","Passwords are not equal");
            return failureRedirect;
        }

        for(User user: claimService.getUsers()) {
            if(singUpForm.getUsername().equals(user.getUsername())) {
                failureRedirect.addParameter("message","Username with this usernname already exists");
                return failureRedirect;
            }

            if(singUpForm.getEmail().equals(user.getEmail())) {
                failureRedirect.addParameter("message","Username with this email already exists");
                return failureRedirect;
            }

        }

        User user = new User(singUpForm.getUsername(), singUpForm.getEmail(), singUpForm.getPassword());
        claimService.saveUser(user);

        HttpSession session = request.getSession();
        session.setAttribute("loggedUser",user);
        return mapping.findForward("success");



    }
}

