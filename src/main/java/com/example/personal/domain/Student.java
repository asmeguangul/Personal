package com.example.personal.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    private int id;

    private String name;
    private String lastName;

    @Column(name ="email")
    @Email
    private String email;

    @OneToMany(mappedBy = "student")
    private List<Course> courses;



}
