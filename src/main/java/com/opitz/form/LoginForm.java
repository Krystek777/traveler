package com.opitz.form;

import com.opitz.model.User;
import com.opitz.repository.UserRepository;
import com.opitz.utility.ServiceLocator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoginForm extends ValidatorForm {

    private String username;
    private String password;

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

        UserRepository userRepository = ServiceLocator.findUserRepository();
        ActionErrors errors = super.validate(mapping, request);

        boolean isUserFound = false;
        for (User user : userRepository.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isUserFound = true;
                break;
            }
        }

        if (!isUserFound) {
            errors.add("password", new ActionMessage("error.wrong.username.password"));
        }

        return errors;
    }
}
