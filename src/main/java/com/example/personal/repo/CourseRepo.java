package com.example.personal.repo;

import com.example.personal.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

    @Query(value = "SELECT * FROM Course WHERE student_Id=:studentId", nativeQuery = true)
    public List<Course> findCourseByStudentId(int studentId);
}
