package com.example.personal.service;

import com.example.personal.domain.Course;
import com.example.personal.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course findById(int courseId) {
        return courseRepo.findById(courseId).get();
    }

    @Override
    public List<Course> findCourseByStudentId(int studentId) {
       List<Course> courses = courseRepo.findCourseByStudentId(studentId);
       return courses;
    }

    @Override
    public Course addCourse(Course course) {
     return courseRepo.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public void removeCourse(int courseId) {
        courseRepo.deleteById(courseId);
    }

}
