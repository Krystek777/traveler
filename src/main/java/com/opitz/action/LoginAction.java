package com.opitz.action;

import com.opitz.form.LoginForm;
import com.opitz.service.ClaimService;
import com.opitz.utility.Logger;
import com.opitz.utility.ServiceLocator;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {

    ClaimService claimService = ServiceLocator.findClaimService();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

                LoginForm loginForm = (LoginForm) form;
                Logger logger = new Logger();
                boolean isValid = logger.isValid(loginForm.getUsername(), loginForm.getPassword());

                if(isValid ) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedUser",claimService.findUser(loginForm.getUsername()));
                    return mapping.findForward("success");
                }

                return mapping.findForward("failure");
    }
}
