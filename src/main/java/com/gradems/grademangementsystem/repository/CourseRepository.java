package com.gradems.grademangementsystem.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.gradems.grademangementsystem.entity.Course;

public interface CourseRepository extends CrudRepository<Course, UUID> {
    
}
