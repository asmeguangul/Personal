package com.example.personal.service;

import com.example.personal.domain.Course;
import com.example.personal.domain.Student;
import com.example.personal.repo.CourseRepo;
import com.example.personal.repo.StudentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Student> getStudentList() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentRepo.findById(studentId).get();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void removeStudent(int studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id " + studentId));

        List<Course> courses = student.getCourses();
        if (courses != null && !courses.isEmpty()) {
            student.getCourses().forEach(course -> course.setStudent(null));
            studentRepo.save(student);
            courses.forEach(course -> courseRepo.delete(course));
        }
        studentRepo.delete(student);
    }

}
