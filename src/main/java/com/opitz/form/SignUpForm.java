package com.opitz.form;


import com.opitz.model.User;
import com.opitz.service.ClaimService;
import com.opitz.utility.ServiceLocator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;


@Data
@EqualsAndHashCode(callSuper = true)
public class SignUpForm extends ValidatorForm {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ClaimService claimService = ServiceLocator.findClaimService();

        ActionErrors errors = super.validate(mapping, request);
        if (!StringUtils.equals(password, confirmPassword)) {
            errors.add("password", new ActionMessage("error.passwords.not.equal"));
        }

        for (User user : claimService.getUsers()) {
            if (username.equals(user.getUsername())) {
                errors.add("password", new ActionMessage("error.username.exists"));
            }

            if (email.equals(user.getEmail())) {
                errors.add("password", new ActionMessage("error.email.exists"));
            }
        }


        return errors;
    }
}