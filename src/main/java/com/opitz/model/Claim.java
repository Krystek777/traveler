package com.opitz.model;


import com.opitz.utility.ClaimConverter;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(of = {"name", "email","policy","claimType",
        "claimAmount", "dateOccurred", "status"})
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 3, max = 32)
    private String name;

    @Column
    @NotNull
    @Pattern(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String email;

    @Column
    @NotNull
    @Size(min = 3, max = 32)
    private String policy;

    @Column
    @NotNull
    private ClaimType claimType;

    @Column
    @NotNull
    private int claimAmount;

    @Column
    @NotNull
    @PastOrPresent
    private Date dateOccurred;

    @Column
    @NotNull
    private ClaimStatus status;


    public Claim() {}

    public Claim(@Size(min = 3, max = 32) String name, @Pattern(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}") String email, @Size(min = 3, max = 32) String policy, ClaimType claimType, int claimAmount, @PastOrPresent Date dateOccurred, ClaimStatus status) {
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
