package com.opitz.action;

import com.opitz.service.ClaimService;
import com.opitz.utility.ServiceLocator;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OnInitAction extends Action {
    private ClaimService claimService = ServiceLocator.findClaimService();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
       request.getServletContext().setAttribute("claims",claimService.getClaims());
        request.getServletContext().setAttribute("users",claimService.getUsers());
        HttpSession session = request.getSession();
        session.setAttribute("loggedUser",null);
        return mapping.findForward("onInit");
    }
}
