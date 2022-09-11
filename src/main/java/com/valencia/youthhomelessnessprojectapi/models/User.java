package com.valencia.youthhomelessnessprojectapi.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

// Lombok
@Getter
@Setter
@ToString
@NoArgsConstructor

// javax.persistence
@Entity

@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String username;

    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password should not be empty")
    @Size(min = 5, message = "Password should be at least 5 characters long.")
    private String password;

    @Column(name = "password_attempts")
    private int passwordAttempts;

    @Column(name = "lockout_date")
    private Date lockoutDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ToString.Exclude
    private Role role;

}
