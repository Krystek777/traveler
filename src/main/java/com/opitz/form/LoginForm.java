package com.opitz.form;

import lombok.Data;
import org.apache.struts.action.ActionForm;

@Data
public class LoginForm extends ActionForm {

    private String username;
    private String password;

}
