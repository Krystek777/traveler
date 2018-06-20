package com.opitz.model;


import com.opitz.utility.ClaimConverter;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.context.annotation.Primary;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @NotNull
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String policy;

    @Column
    @NotNull
    private ClaimType claimType;

    @Column
    @NotNull
    private int claimAmount;

    @Column
    @NotNull
    private Date dateOccurred;

    @Column
    @NotNull
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
