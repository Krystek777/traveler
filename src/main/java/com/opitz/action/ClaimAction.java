package com.opitz.action;

import com.opitz.form.ClaimForm;
import com.opitz.model.Claim;
import com.opitz.service.ClaimService;
import com.opitz.utility.ClaimConverter;
import com.opitz.utility.ServiceLocator;
import com.opitz.utility.Validator;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ClaimAction extends Action {


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        ClaimConverter claimConverter = new ClaimConverter();

        ClaimForm claimForm = (ClaimForm)form;

        ClaimService claimService = ServiceLocator.findClaimService();
        Claim claim = claimConverter.toClaim(claimForm);
        claimService.saveClaim(claim);

        HttpSession session = request.getSession(true);
        session.setAttribute("claims", claimService.getClaims());
        return mapping.findForward("success");
    }
}

