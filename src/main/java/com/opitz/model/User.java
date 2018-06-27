package com.opitz.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(unique = true)
    @Size(min = 3, max = 32)
    private String username;

    @Column
    @Pattern(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String email;


    @Column
    @Size(min = 4, max = 32)
    private String password;

    public User() {
    }

    public User(@Size(min = 3, max = 32) String username,
                @Pattern(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}") String email,
                @Size(min = 4, max = 32) String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }
}
