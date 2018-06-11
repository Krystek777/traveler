package com.opitz.action;

import com.opitz.form.LoginForm;
import com.opitz.form.SignUpForm;
import com.opitz.model.User;
import com.opitz.service.ClaimService;
import com.opitz.utility.Logger;
import com.opitz.utility.ServiceLocator;
import org.apache.struts.action.*;
import org.apache.struts.actions.MappingDispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAction extends MappingDispatchAction {

    private ClaimService claimService = ServiceLocator.findClaimService();

    public ActionForward login(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response) throws Exception {

        return mapping.findForward("success");
    }

    public ActionForward loginSubmit(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginForm loginForm = (LoginForm) form;
        Logger logger = new Logger();
        boolean isValid = logger.isValid(loginForm.getUsername(), loginForm.getPassword());

        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", claimService.findUser(loginForm.getUsername()));
            return mapping.findForward("success");
        }

        return mapping.findForward("failure");
    }


    public ActionForward signUp(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("success");
    }

    public ActionForward saveUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClaimService claimService = ServiceLocator.findClaimService();
        SignUpForm signUpForm = (SignUpForm) form;

        User user = new User(signUpForm.getUsername(), signUpForm.getEmail(), signUpForm.getPassword());
        claimService.saveUser(user);

        HttpSession session = request.getSession();
        session.setAttribute("loggedUser", user);
        return mapping.findForward("success");
    }


    public ActionForward signOut(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("loggedUser", null);
        return mapping.findForward("success");
    }
}
