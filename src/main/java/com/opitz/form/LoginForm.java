package com.opitz.form;

import com.opitz.model.User;
import com.opitz.repository.UserRepository;
import com.opitz.service.ClaimService;
import com.opitz.utility.ServiceLocator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoginForm extends ValidatorForm {

    private String username;
    private String password;


    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request, ClaimService claimService) {

        ActionErrors errors = new ActionErrors();

        boolean isUserFound = false;
        for (User user : claimService.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isUserFound = true;
                break;
            }
        }

        if (!isUserFound) {
            errors.add("loginImpossible", new ActionMessage("error.wrong.username.password"));
        }

        return errors;
    }
}
