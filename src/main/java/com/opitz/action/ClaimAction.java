package com.opitz.action;

import com.opitz.form.ClaimForm;
import com.opitz.model.Claim;
import com.opitz.model.ClaimType;
import com.opitz.model.TypeOption;
import com.opitz.model.User;
import com.opitz.repository.UserRepository;
import com.opitz.service.ClaimService;
import com.opitz.utility.ClaimConverter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.util.MessageResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class ClaimAction extends MappingDispatchAction {

    @Autowired
    private ClaimService claimService;

    @Autowired
    private ClaimConverter claimConverter;



    public ActionForward addClaim(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        ClaimForm claimForm = (ClaimForm) form;
        List<TypeOption> typeOptions = new ArrayList<>();
        MessageResources resources = getResources(request);

        for (ClaimType type : ClaimType.values()) {
            typeOptions.add(new TypeOption(type, resources.getMessage("claimForm.types." + type.name())));
        }
        claimForm.setTypeOptions(typeOptions);

        return mapping.findForward("success");

    }

    public ActionForward addClaimSubmit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {

//        ClaimConverter claimConverter = getWebApplicationContext().getBean("claimConverter", ClaimConverter.class);
        ClaimForm claimForm = (ClaimForm) form;

        Claim claim = claimConverter.convertToClaim(claimForm);
//        ClaimService claimService = getWebApplicationContext().getBean("claimService", ClaimService.class);
        claimService.saveClaim(claim);
        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("claim.added"));
        saveMessages(request, messages);
        return mapping.findForward("success");
    }


    public ActionForward allClaims(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) {
        //ClaimService claimService = getWebApplicationContext().getBean("claimService", ClaimService.class);
        request.getServletContext().setAttribute("claims", claimService.getClaims());
        return mapping.findForward("success");
    }

}

