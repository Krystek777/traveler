package com.opitz.action;

import com.opitz.form.ClaimForm;
import com.opitz.model.Claim;
import com.opitz.service.ClaimService;
import com.opitz.utility.ClaimConverter;
import com.opitz.utility.ServiceLocator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class ClaimAction extends MappingDispatchAction {

    private ClaimService claimService = ServiceLocator.findClaimService();

    public ActionForward addClaim (ActionMapping mapping, ActionForm form, HttpServletRequest request,
    HttpServletResponse response) throws Exception{
        ClaimForm claimForm = (ClaimForm) form;
        List<String> statuses = new ArrayList();
        claimForm.setStatuses(statuses);
        return mapping.findForward("success");

    }

    public ActionForward addClaimSubmit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        ClaimConverter claimConverter = new ClaimConverter();
        ClaimForm claimForm = (ClaimForm)form;
        Claim claim = claimConverter.convertToClaim(claimForm);
        claimService.saveClaim(claim);

        return mapping.findForward("success");
    }


    public ActionForward allClaims(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        request.getServletContext().setAttribute("claims",claimService.getClaims());
        return mapping.findForward("success");
    }

}

