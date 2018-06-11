package com.opitz.utility;

import com.opitz.form.ClaimForm;
import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.service.ClaimService;
import lombok.extern.log4j.Log4j;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j
public class ClaimConverter {

    private static final String DATE_FORMAT = "yyyy/MM/dd";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);

    private static Date parseDate(String dateToParse) throws TravelerParseException{
        try {
            return SIMPLE_DATE_FORMAT.parse(dateToParse);
        } catch (ParseException e) {
            log.error("Could not parse " + dateToParse, e);
            throw new TravelerParseException("Wrong date to parse", e);
        }
    }

    public static String formatDate(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }

    public Claim convertToClaim(ClaimForm claimForm) throws TravelerException {


        Claim claim = new Claim(0, claimForm.getName(), claimForm.getEmail(),
                claimForm.getPolicy(), claimForm.getClaimType(), Integer.parseInt(claimForm.getClaimAmount()),
                null, ClaimStatus.NEW);

        claim.setDateOccurred(parseDate(claimForm.getDateOccurred()));
        ClaimService claimService = ServiceLocator.findClaimService();
        claim.setId((long) (claimService.getClaims().size()) + 1);

        return claim;

    }

}
