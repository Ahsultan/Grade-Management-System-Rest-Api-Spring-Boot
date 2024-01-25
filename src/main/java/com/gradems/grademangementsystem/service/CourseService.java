package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.UUID;

import com.gradems.grademangementsystem.entity.Course;

public interface CourseService {
    Course getCourse(UUID id);
    Course saveCourse(Course course);
    void deleteCourse(UUID id);
    List<Course> getCourses();
}