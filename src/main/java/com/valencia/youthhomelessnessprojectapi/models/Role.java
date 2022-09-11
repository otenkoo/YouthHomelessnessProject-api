package com.valencia.youthhomelessnessprojectapi.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


// Lombok
@Getter
@Setter
@NoArgsConstructor

// Lombok
@Entity
@Table(name =  "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name=  "id",unique  = true)
    private long Id;

    @Column(name= "name")
    private String Name;

}
