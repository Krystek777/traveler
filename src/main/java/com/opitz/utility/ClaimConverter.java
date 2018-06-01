package com.opitz.utility;

import com.opitz.form.ClaimForm;
import com.opitz.model.Claim;
import com.opitz.model.ClaimStatusString;
import com.opitz.service.ClaimService;


import java.sql.Date;

public class ClaimConverter {


    public Claim toClaim(ClaimForm claimForm) {
        Claim claim = new Claim(0,claimForm.getName(), claimForm.getEmail(),
                claimForm.getPolicy(), claimForm.getClaimType(), Integer.parseInt(claimForm.getClaimAmount()),
                null, ClaimStatusString.NEW);
    String dateString = claimForm.getDateOccurred();
        int year = Integer.parseInt(dateString.substring(0,4)) - 1900;
        int month = Integer.parseInt(dateString.substring(5,7));
        int day =    Integer.parseInt(dateString.substring(8,10));
        Date date = new Date(year, month, day);
        claim.setDateOccurred(date);

        ClaimService claimService = ServiceLocator.findClaimService();
        claim.setId((long)(claimService.getClaims().size()) + 1);

        return claim;

    }

}
