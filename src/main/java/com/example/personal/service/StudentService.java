package com.example.personal.service;

import com.example.personal.domain.Student;

import java.util.List;


public interface StudentService {

    public List<Student> getStudentList();

    public Student getStudentById(int studentId);

    public void removeStudent(int studentId);

    public Student addStudent(Student student);

}
