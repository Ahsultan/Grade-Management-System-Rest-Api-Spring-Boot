package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.UUID;

import com.gradems.grademangementsystem.entity.Course;
import com.gradems.grademangementsystem.entity.Student;

public interface StudentService {
    Student getStudent(UUID id);
    Student saveStudent(Student student);
    void deleteStudent(UUID id);
    List<Student> getStudents();
    List<Course> getEnrolledCourses(UUID studentId);
}
