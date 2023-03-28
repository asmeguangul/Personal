package com.example.personal.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastName;

    @Column(name ="email")
    @Email
    private String email;

    @OneToMany(cascade  = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "course_student", joinColumns = {@JoinColumn(name = "courseId")}, inverseJoinColumns = {@JoinColumn(name = "studentId")})
    @JsonBackReference

    private List<Course> courses;

}
