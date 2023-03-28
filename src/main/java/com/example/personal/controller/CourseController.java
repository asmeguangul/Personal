package com.example.personal.controller;

import com.example.personal.domain.Course;
import com.example.personal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.findById(id);
    }

    @GetMapping
    public List<Course> findAllCourse(){
        return courseService.findAll();
    }

    @PostMapping
    public Course postCourse(@RequestBody Course course){
       return courseService.addCourse(course);
    }

    @GetMapping("student/{studentId}")
    public List<Course> findAllCourseByCourseId(@PathVariable int studentId){
        return courseService.findCourseByStudentId(studentId);
    }
      @DeleteMapping("/{courseId}")
    public void deleteCourseByCourseId(@PathVariable int    courseId){
        courseService.removeCourse(courseId);
          System.out.println("course dleleted");
      }
}
