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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;


@Data
@EqualsAndHashCode(callSuper = true)
public class SignUpForm extends ValidatorForm {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;



    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request, ClaimService claimService) {


        ActionErrors errors = new ActionErrors();

        if (!StringUtils.equals(password, confirmPassword)) {
            errors.add("passwordsEquality", new ActionMessage("error.passwords.not.equal"));
        }

        for (User user : claimService.getUsers()) {
            if (username.equals(user.getUsername())) {
                errors.add("usernameError", new ActionMessage("error.username.exists"));
            }

            if (email.equals(user.getEmail())) {
                errors.add("emailError", new ActionMessage("error.email.exists"));
            }
        }


        return errors;
    }
}