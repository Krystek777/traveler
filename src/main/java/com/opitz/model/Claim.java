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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
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


    public Claim() {
        this(0, "", "", "", null, 0, new Date(2010, 10, 10), ClaimStatus.NEW);
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
