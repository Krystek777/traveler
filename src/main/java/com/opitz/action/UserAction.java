package com.opitz.action;

import com.opitz.form.LoginForm;
import com.opitz.form.SignUpForm;
import com.opitz.model.User;
import com.opitz.repository.UserRepository;
import com.opitz.service.ClaimService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class UserAction extends MappingDispatchAction {

    @Autowired
    private ClaimService claimService;

    @Autowired
    @Qualifier("HibernateUserRepository")
    private UserRepository userRepository;

    public ActionForward login(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("success");
    }

    public ActionForward loginSubmit(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginForm loginForm = (LoginForm) form;

        saveErrors(request,loginForm.validate(mapping, request, claimService) );

        if(getErrors(request).isEmpty()) {
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

        SignUpForm signUpForm = (SignUpForm) form;

        saveErrors(request,signUpForm.validate(mapping, request, claimService) );

        if(getErrors(request).isEmpty()){
            User user = new User(0, signUpForm.getUsername(), signUpForm.getEmail(), signUpForm.getPassword());
            claimService.saveUser(user);
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", user);
        }

        return mapping.findForward("success");
    }


    public ActionForward signOut(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("loggedUser", null);
        return mapping.findForward("success");
    }

    public ActionForward welcome(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("success");
    }
}
