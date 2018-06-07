package com.opitz.form;


import lombok.Data;
import org.apache.struts.validator.ValidatorForm;




@Data
public class SingUpForm extends ValidatorForm {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;

}