package com.example.personal.service;

import com.example.personal.domain.Course;

import java.util.List;


public interface CourseService {
    public Course findById(int courseId);
    public List<Course> findCourseByStudentId(int studentId);

    public Course addCourse(Course course);

    public List<Course> findAll();
}
