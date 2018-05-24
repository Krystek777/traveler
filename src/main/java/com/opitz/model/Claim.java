package com.opitz.model;


import java.util.Date;

public class Claim {

    private String name;
    private String email;
    private String policy;
    private String claimType;
    private int claimAmount;
    private Date dateOccurred;
    private String status;

    public Claim() {
        this("","","",null,0, new Date(2010, 10,10), "new");
    }

    public Claim(String name, String email, String policy,
                 String claimType, int claimAmount, Date dateOccurred, String status) {
        this.name = name;
        this.email = email;
        this.policy = policy;
        this.claimType = claimType;
        this.claimAmount = claimAmount;
        this.dateOccurred = dateOccurred;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public int getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(int claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Date getDateOccurred() {
        return dateOccurred;
    }

    public void setDateOccurred(Date dateOccurred) {
        this.dateOccurred = dateOccurred;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
