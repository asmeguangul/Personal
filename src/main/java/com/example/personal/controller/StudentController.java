package com.example.personal.controller;

import com.example.personal.domain.Student;
import com.example.personal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
   private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getStudentList();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId){
        studentService.removeStudent(studentId);
    }
}
