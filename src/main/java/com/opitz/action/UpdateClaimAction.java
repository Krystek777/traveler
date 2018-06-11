package com.opitz.action;

import com.opitz.model.ClaimStatus;
import com.opitz.service.ClaimService;
import com.opitz.utility.ServiceLocator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateClaimAction extends MappingDispatchAction {


    public ActionForward approveClaim(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        return updateClaim(ClaimStatus.APPROVED, mapping, form, request, response);

    }

    public ActionForward rejectClaim(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        return updateClaim(ClaimStatus.REJECTED, mapping, form, request, response);
    }

    private ActionForward updateClaim(String status, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClaimService claimService = ServiceLocator.findClaimService();
        long id = Long.valueOf(request.getParameter("id"));
        claimService.setStatus(id, status);

        return mapping.findForward("success");
    }
}
