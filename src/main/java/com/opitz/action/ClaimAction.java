package com.opitz.action;

import com.opitz.form.ClaimForm;
import com.opitz.model.Claim;
import com.opitz.model.ClaimType;
import com.opitz.model.TypeOption;
import com.opitz.service.ClaimService;
import com.opitz.utility.ClaimConverter;
import com.opitz.utility.ServiceLocator;
import org.apache.struts.action.*;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.util.MessageResources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class ClaimAction extends MappingDispatchAction {

    private ClaimService claimService = ServiceLocator.findClaimService();

    public ActionForward addClaim (ActionMapping mapping, ActionForm form, HttpServletRequest request,
    HttpServletResponse response) throws Exception {
        ClaimForm claimForm = (ClaimForm) form;
        List<ClaimType> types = new ArrayList<>(Arrays.asList(ClaimType.values()));
        List<TypeOption> typeOptions = new ArrayList<>();
        MessageResources resources = getResources(request);
        for(ClaimType type: ClaimType.values()) {
            typeOptions.add(new TypeOption(type, resources.getMessage("claimForm.types." + type.name())));
        }
        claimForm.setTypeOptions(typeOptions);

        return mapping.findForward("success");

    }

    public ActionForward addClaimSubmit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        ClaimConverter claimConverter = new ClaimConverter();
        ClaimForm claimForm = (ClaimForm)form;

        Claim claim = claimConverter.convertToClaim(claimForm);
        claimService.saveClaim(claim);
        ActionMessages messages = new ActionMessages();
        messages.add("claimAdded",new ActionMessage("claim.added"));
        saveMessages(request, messages);
        return mapping.findForward("success");
    }


    public ActionForward allClaims(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        request.getServletContext().setAttribute("claims",claimService.getClaims());
        return mapping.findForward("success");
    }

}

