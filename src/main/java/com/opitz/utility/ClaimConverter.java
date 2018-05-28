package com.opitz.utility;

import com.opitz.form.ClaimForm;
import com.opitz.model.Claim;
import com.opitz.model.ClaimStatusString;


import java.sql.Date;

public class ClaimConverter {


    public Claim toClaim(ClaimForm claimForm) {
//        Claim claim = new Claim();
//        return BeanUtils.copyProperties(claim, claimForm);
        Claim claim = new Claim(claimForm.getName(), claimForm.getEmail(),
                claimForm.getPolicy(), claimForm.getClaimType(), Integer.parseInt(claimForm.getClaimAmount()),
                null, ClaimStatusString.NEW);
    String dateString = claimForm.getDateOccurred();
        int year = Integer.parseInt(dateString.substring(0,4)) - 1900;
        int month = Integer.parseInt(dateString.substring(5,7));
        int day =    Integer.parseInt(dateString.substring(8,10));
        Date date = new Date(year, month, day);
        claim.setDateOccurred(date);

        return claim;

    }

}
