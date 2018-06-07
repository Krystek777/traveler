package com.opitz.action;

import com.opitz.form.SingUpForm;
import com.opitz.model.User;
import com.opitz.service.ClaimService;
import com.opitz.utility.ServiceLocator;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingUpAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClaimService claimService = ServiceLocator.findClaimService();
        SingUpForm singUpForm = (SingUpForm) form;

        if (!singUpForm.getPassword().equals(singUpForm.getConfirmPassword())) {
            ActionRedirect redirect = new ActionRedirect(mapping.findForward("failure"));
            redirect.addParameter("message","Passwords not equal");
            return redirect;
        }

        for(User user: claimService.getUsers()) {
            if(singUpForm.getUsername().equals(user.getUsername())) {
                return mapping.findForward("usernameExists");
            }

            if(singUpForm.getEmail().equals(user.getEmail())) {
                return mapping.findForward("emailExists");
            }

        }

        claimService.saveUser(new User(singUpForm.getUsername(), singUpForm.getEmail(), singUpForm.getPassword()));

        return mapping.findForward("success");



    }
}

