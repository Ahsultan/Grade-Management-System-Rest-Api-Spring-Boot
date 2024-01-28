package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.UUID;

import com.gradems.grademangementsystem.entity.Course;
import com.gradems.grademangementsystem.entity.Student;

public interface CourseService {
    Course getCourse(UUID id);
    Course saveCourse(Course course);
    Course addStudentToCourse(UUID courseId, UUID studentId);
    void deleteCourse(UUID id);
    List<Course> getCourses();
    List<Student> getEnrolledStudents(UUID courseId);
}