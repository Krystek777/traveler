package com.opitz.model;


import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Claim {

    private long id;
    private String name;
    private String email;
    private String policy;
    private String claimType;
    private int claimAmount;
    private Date dateOccurred;
    private String status;

    public Claim() {
        this(1, "", "", "", null, 0, new Date(2010, 10, 10), ClaimStatusString.NEW);
    }

    public Claim(long id, String name, String email, String policy,
                 String claimType, int claimAmount, Date dateOccurred, String status) {
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
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
        return (ft.format(dateOccurred));
    }

    public void setDateOccurred(Date dateOccurred) {
        this.dateOccurred = dateOccurred;
    }


}
