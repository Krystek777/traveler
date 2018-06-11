package com.opitz.form;


import lombok.Data;
import org.apache.struts.validator.ValidatorForm;

import java.util.List;


@Data
public class ClaimForm extends ValidatorForm {

    private String name;
    private String email;
    private String policy;
    private String claimType;
    private String claimAmount;
    private String dateOccurred;
    private String status;

    private List<String> statuses;

}
