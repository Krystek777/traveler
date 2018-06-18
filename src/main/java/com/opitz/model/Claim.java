package com.opitz.model;


import com.opitz.utility.ClaimConverter;
import lombok.Data;

import javax.persistence.Entity;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Claim {

    private long id;
    private String name;
    private String email;
    private String policy;
    private ClaimType claimType;
    private int claimAmount;
    private Date dateOccurred;
    private ClaimStatus status;

    public Claim() {
        this(1, "", "", "", null, 0, new Date(2010, 10, 10), ClaimStatus.NEW);
    }

    public Claim(long id, String name, String email, String policy,
                 ClaimType claimType, int claimAmount, Date dateOccurred, ClaimStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.policy = policy;
        this.claimType = claimType;
        this.claimAmount = claimAmount;
        this.dateOccurred = dateOccurred;
        this.status = status;
    }

    public String getDateOccurred() {
        return ClaimConverter.formatDate(dateOccurred);
    }


}
